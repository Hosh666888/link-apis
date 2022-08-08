package pro.goforit.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pro.goforit.consts.LogConst;
import pro.goforit.domain.User;
import pro.goforit.domain.user.GithubUser;
import pro.goforit.domain.user.LoginUser;
import pro.goforit.mapper.UserMapper;
import pro.goforit.service.ILoginService;
import pro.goforit.service.IUserService;

import javax.annotation.Resource;

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

    @Override
    public LoginUser loginWithGithub(GithubUser githubUser) {
        Assert.notNull(githubUser,"参数不可为空");
        log.info(LogConst.LOG_INFO,"github登录",githubUser);
        User user = iUserService.selectByGithubId(githubUser.getId());
        if (user==null){
            log.info("该github用户第一次登录 正在持久化至数据库");
            user = iUserService.insertFromGithubUser(githubUser);
            log.info("成功持久化github用户");
        }

        LoginUser loginUser = LoginUser.fromUser(user);

        // TODO: 2022/8/8 缓存用户 




        return loginUser;
    }
}
