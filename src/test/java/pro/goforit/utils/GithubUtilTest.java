package pro.goforit.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import pro.goforit.domain.user.GithubUser;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 16:11
 * @desc:
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubUtilTest {
    @Resource
    private RestTemplate restTemplate;

    @Test
    void getGithubTokenFromCode() {

        System.out.println(GithubUtil.getGithubTokenFromCode("7cb6a3f6e514d14258eb", restTemplate));

    }

    @Test
    void getGithubProfileByToken() {
        GithubUser githubUser = GithubUtil.getGithubProfileByToken("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", restTemplate);
        System.out.println(githubUser);
    }
}