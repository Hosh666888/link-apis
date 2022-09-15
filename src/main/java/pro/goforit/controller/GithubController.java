package pro.goforit.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pro.goforit.conf.GithubConfig;
import pro.goforit.domain.returns.R;
import pro.goforit.domain.user.GithubUser;
import pro.goforit.domain.user.LoginUser;
import pro.goforit.service.ILoginService;
import pro.goforit.utils.GithubUtil;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 14:44
 * @desc:
 **/
@RestController
@CrossOrigin
public class GithubController {

    @Resource
    private ILoginService loginService;

    // https://github.com/login/oauth/authorize?client_id=883857950cb7ee43a362

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/github/callback")
    @CrossOrigin
    public R<LoginUser> githubCallback(@RequestParam("code")String code){

        //获取token
        String token = GithubUtil.getGithubTokenFromCode(code, restTemplate);
        //获取github信息
        GithubUser githubUser = GithubUtil.getGithubProfileByToken(token, restTemplate);
        // TODO: 2022/8/8 查询用户 无则入库    缓存当前用户  返回前端LoginUser
        LoginUser loginUser = loginService.loginWithGithub(githubUser);

        return R.success(loginUser);

    }





}
