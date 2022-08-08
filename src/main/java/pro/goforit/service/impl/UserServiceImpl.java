package pro.goforit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.goforit.consts.LogConst;
import pro.goforit.domain.User;
import pro.goforit.domain.user.GithubUser;
import pro.goforit.mapper.UserMapper;
import pro.goforit.service.IUserService;

import java.util.Date;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 16:41
 * @desc:
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectByGithubId(Long githubId) {
        log.info(LogConst.LOG_INFO,"根据github id查询用户",githubId);
        LambdaQueryWrapper<User> lambda = Wrappers.<User>lambdaQuery();
        lambda.eq(User::getGithubId, githubId);
        return userMapper.selectOne(lambda);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User insertFromGithubUser(GithubUser githubUser) {
        log.info(LogConst.LOG_INFO,"插入github user",githubUser);

        User user = new User().setNickName(githubUser.getLogin())
                            .setGithubId(githubUser.getId())
                            .setAvatar(githubUser.getAvatar_url())
                            .setGithubHomeUrl(githubUser.getHtml_url())
                            .setEmail(githubUser.getEmail())
                            .setCreateTime(new Date());

        userMapper.insert(user);
        return userMapper.selectOne(
                Wrappers.<User>lambdaQuery().eq(User::getGithubId,githubUser.getId())
        );
    }
}
