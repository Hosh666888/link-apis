package pro.goforit.service;

import pro.goforit.domain.user.GithubUser;
import pro.goforit.domain.user.LoginUser;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 16:57
 * @desc:
 **/
public interface ILoginService {

    LoginUser loginWithGithub(GithubUser githubUser);

}
