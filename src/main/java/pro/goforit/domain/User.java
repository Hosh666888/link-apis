package pro.goforit.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@Accessors(chain = true)
public class User implements Serializable {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 用户名
     */
    private String username;


    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer gender;


    private String email;

    /**
     * 角色
     */
    private String role;

    /**
     * 经验值
     */
    private Long experience;


    private Date createTime;

    /**
     * 标记位
     */
    private Integer flag;

    /**
     * 头像url
     */
    private String avatar;


    private Long githubId;


    private String githubHomeUrl;

    @TableField(exist = false)
    private static final long serialVersionUID = 8928446797260407579L;
}