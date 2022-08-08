package pro.goforit.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import pro.goforit.conf.GithubConfig;
import pro.goforit.domain.user.GithubUser;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 15:51
 * @desc:
 **/
@Slf4j
public class GithubUtil {

    private final static  String URL_GET_TOKEN = "https://github.com/login/oauth/access_token";
    private final static  String URL_GET_PROFILE = "https://api.github.com/user";

    /**
     *  获取github token
     * @param code
     * @param restTemplate
     * @return
     */
    public static String getGithubTokenFromCode(String code,RestTemplate restTemplate){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject body = new JSONObject();
        body.put("code",code);
        body.put("client_id", GithubConfig.CLIENT_ID);
        body.put("client_secret",GithubConfig.SECRETS);
        HttpEntity<JSONObject> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> exchange;

        try {
            exchange = restTemplate.exchange(URL_GET_TOKEN, HttpMethod.POST, entity, String.class);
        }catch (Exception e){
            log.error("获取github token时出错,{}",e.getMessage(),e);
            throw new RuntimeException("获取github token时出现错误");
        }

        String response = exchange.getBody();

        if (response==null || !response.startsWith("access_token")){
            log.error("获取github token时出错,token={}",response);
            throw new RuntimeException("获取github token时出错");
        }

        // 返回值样例
        // access_token=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&scope=&token_type=bearer

        return response.split("&")[0].split("=")[1];

    }


    /**
     *      获取github用户信息
     * @param token
     * @param restTemplate
     * @return
     */
    public static GithubUser getGithubProfileByToken(String token, RestTemplate restTemplate){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",String.format("token %s",token));
        HttpEntity<Void> entity = new HttpEntity<>(null,headers);

        ResponseEntity<GithubUser> responseEntity = null;

        try {
            responseEntity = restTemplate.exchange(URL_GET_PROFILE, HttpMethod.GET, entity, GithubUser.class);
        }catch (Exception e){
            log.error("获取github个人信息失败,"+e.getMessage(),e);
            throw new RuntimeException("获取github个人信息失败");
        }

        return responseEntity.getBody();
    }



}
