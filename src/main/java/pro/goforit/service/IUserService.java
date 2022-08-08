package pro.goforit.service;

import pro.goforit.domain.User;
import pro.goforit.domain.user.GithubUser;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 16:40
 * @desc:
 **/
public interface IUserService {

    User selectByGithubId(Long githubId);

    User insertFromGithubUser(GithubUser githubUser);

}
