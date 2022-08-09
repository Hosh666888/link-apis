package pro.goforit.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pro.goforit.consts.LogConst;
import pro.goforit.domain.User;
import pro.goforit.domain.user.GithubUser;
import pro.goforit.domain.user.LoginUser;
import pro.goforit.service.ILoginService;
import pro.goforit.service.IUserService;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 17:07
 * @desc:
 **/
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {
    @Resource
    private IUserService iUserService;

    //分钟
    @Value("${login.ttl}")
    private int ttl;



    //token:loginUser
    private static final ConcurrentHashMap<String,LoginUser> loginUserMap = new ConcurrentHashMap<>(16);

    //userid:token
    private static final ConcurrentHashMap<Long,String> userMap = new ConcurrentHashMap<>(16);


    @Override
    public LoginUser loginWithGithub(GithubUser githubUser) {
        Assert.notNull(githubUser,"参数不可为空");
        log.info(LogConst.ENTER_METHOD_LOG,"github登录",githubUser);
        User user = iUserService.selectByGithubId(githubUser.getId());
        if (user==null){
            log.info("该github用户[{}]第一次登录 正在持久化至数据库",githubUser.getLogin());
            user = iUserService.insertFromGithubUser(githubUser);
            log.info("成功持久化github用户[{}]",githubUser.getLogin());
        }

        return cacheUser(user);
    }


    private Long computeExpireIn(){
        return System.currentTimeMillis()+ ttl*60*1000;
    }

    private LoginUser cacheUser(User user){
        LoginUser loginUser = LoginUser.fromUser(user);
        loginUser.setExpireIn(computeExpireIn());

        Long userId = loginUser.getId();
        String niceName = loginUser.getNickName();

        //当前用户未登录 -》缓存
        if (!userMap.containsKey(userId)){
            log.info("正在写入用户[{}]信息至缓存",niceName);
            String token  = loginUser.getToken();
            userMap.put(userId,token);
            loginUserMap.put(token,loginUser);
            log.info("成功写入用户[{}]信息,签发token:[{}]",niceName,token);
        }else{
            //续期
            log.info("正在为用户[{}]延长token过期时效",niceName);
            String s = userMap.get(userId);
            LoginUser loginUser1 = loginUserMap.get(s);
            loginUser1.setExpireIn(computeExpireIn());
            loginUserMap.put(s,loginUser1);
        }
        return loginUserMap.get(loginUser.getToken());
    }


    /**
     *  当前用户token过期则会清空2个map然后返回空
     * @param token
     * @return
     */
    public static LoginUser getLoginUsesByToken(String token){
        if (loginUserMap.containsKey(token)){
            LoginUser loginUser = loginUserMap.get(token);
            if (System.currentTimeMillis()>loginUser.getExpireIn()){
                return loginUser;
            }else{
                Long userId = loginUser.getId();
                loginUserMap.remove(token);
                userMap.remove(userId);
                return null;
            }
        }
        return null;
    }


}
