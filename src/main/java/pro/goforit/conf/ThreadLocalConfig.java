package pro.goforit.conf;

import org.springframework.util.StringUtils;
import pro.goforit.domain.user.LoginUser;
import pro.goforit.exceptions.AuthFailException;
import pro.goforit.service.impl.CacheServiceImpl;
import pro.goforit.service.impl.LoginServiceImpl;

import java.util.function.Supplier;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/9 9:46
 * @desc:
 **/
public class ThreadLocalConfig {
    private static ThreadLocal<LoginUser> threadLocal = ThreadLocal.<LoginUser>withInitial(LoginUser::new);


    public static void set(LoginUser user){
        threadLocal.remove();
        threadLocal.set(user);
    }

    public static LoginUser get(){
        return threadLocal.get();
    }

    public static String getNiceName(){
        LoginUser loginUser = get();
        String niceName = loginUser.getNickName();
        if (!StringUtils.hasText(niceName)){
            throw new AuthFailException("未能从token中获取用户信息,请尝试重新登陆！");
        }
        return niceName;
    }


    public static Long getUserId(){
        LoginUser loginUser = get();
        Long userId = loginUser.getId();
        if (userId==null){
            throw new AuthFailException("未能从token中获取用户信息,请尝试重新登陆！");
        }
        return userId;
    }

    public static void remove(){
        threadLocal.remove();
    }


}
