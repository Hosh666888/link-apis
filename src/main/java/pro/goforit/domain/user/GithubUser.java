package pro.goforit.domain.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/8 15:46
 * @desc:
 **/
@Data
public class GithubUser implements Serializable {
    private static final long serialVersionUID = -2076411289641701491L;

    //昵称
    private String login;

    private Long id;
    private String avatar_url;
    private String html_url;
    private String email;


}
