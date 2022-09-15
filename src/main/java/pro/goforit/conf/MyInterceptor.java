package pro.goforit.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pro.goforit.domain.user.LoginUser;
import pro.goforit.service.impl.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/9 9:43
 * @desc:
 **/
@Component
@Slf4j
public class MyInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //token有效则注入登录信息到threadLocal
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token)){
            LoginUser loginUser = LoginServiceImpl.getLoginUsesByToken(token);
            if (loginUser!=null){
                ThreadLocalConfig.set(loginUser);
                String requestURI = request.getRequestURI();
                log.info("-----------------------------------------------");
                log.info("[{}]正在访问[{}]",ThreadLocalConfig.getNiceName(),requestURI);
            }
        }else{
            //后期删除
            LoginUser loginUser = new LoginUser();
            loginUser.setId(1556843175833477122L);
            ThreadLocalConfig.set(loginUser);
            //后期删除
        }

        return super.preHandle(request, response, handler);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUser loginUser = ThreadLocalConfig.get();
        if (StringUtils.hasText(loginUser.getToken())){
            ThreadLocalConfig.remove();
            log.info("[{}]结束访问",loginUser.getNickName());
            log.info("-----------------------------------------------");
        }

        super.afterCompletion(request, response, handler, ex);
    }
}
