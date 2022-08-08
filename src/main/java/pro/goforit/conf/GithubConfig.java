package pro.goforit.conf;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 14:40
 * @desc:
 **/
@Configuration
@ConfigurationProperties(prefix = "login.github")
public class GithubConfig implements InitializingBean {

    public static String CLIENT_ID;
    public static String SECRETS;


    @Value("${login.github.clientId}")
    private String clientId;
    @Value("${login.github.secrets}")
    private String clientSecrets;


    @Override
    public void afterPropertiesSet() throws Exception {
        CLIENT_ID = clientId;
        SECRETS = clientSecrets;
    }

}
