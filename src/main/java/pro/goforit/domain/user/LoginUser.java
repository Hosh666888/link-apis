package pro.goforit.domain.user;

import lombok.Data;
import lombok.experimental.Accessors;
import pro.goforit.domain.User;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 15:38
 * @desc:
 **/
@Data
@Accessors(chain = true)
public class LoginUser implements Serializable {
    private static final long serialVersionUID = -8981755875367583222L;


    private Long id;

    private Long gitHubId;

    private String gitHubName;

    private String nickName;

    private String avatarUrl;

    private String email;

    private String gitHubHomePage;

    private String role;


    public static LoginUser fromUser(User user){
        return new LoginUser().setId(user.getId())
                                .setGitHubId(user.getGithubId())
                                .setNickName(user.getNickName())
                                .setAvatarUrl(user.getAvatar())
                                .setEmail(user.getEmail())
                                .setGitHubHomePage(user.getGithubHomeUrl())
                                .setRole(user.getRole());
    }

}
