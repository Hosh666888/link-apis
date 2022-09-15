package pro.goforit.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.omg.CORBA.IDLType;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Double.j
 * @create 2022/8/23 21:52
 * @e-mail zjj20001031@foxmail.com / gugezhang872@gmail.com
 */
@Data
@TableName("article")
public class Article implements Serializable {


    @TableId
    private String id;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private String title;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private String labels;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private String content;

    @TableField(value = "plain_text",insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private String plainText;

    @TableField(value = "if_reprinted",insertStrategy = FieldStrategy.NOT_NULL,updateStrategy = FieldStrategy.NOT_NULL)
    private Boolean ifReprinted;

    @TableField(value = "reprinted_url",insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private String reprintedUrl;

    @TableField(value = "if_top",insertStrategy = FieldStrategy.NOT_NULL,updateStrategy = FieldStrategy.NOT_NULL)
    private Boolean ifTop;

    @TableField(value = "cover_image_url",insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private String coverImageUrl;

    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private String remark;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL,updateStrategy = FieldStrategy.NOT_NULL)
    private Long heat;

    @TableField(value = "create_user",insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private Long createUser;

    @TableField(value = "create_time",insertStrategy = FieldStrategy.NOT_NULL,updateStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;

    @TableField(value = "update_user",insertStrategy = FieldStrategy.NOT_EMPTY,updateStrategy = FieldStrategy.NOT_EMPTY)
    private Long updateUser;

    @TableField(value = "update_time",insertStrategy = FieldStrategy.NOT_NULL,updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

    @TableField(value = "delete_flag",insertStrategy = FieldStrategy.NOT_NULL,updateStrategy = FieldStrategy.NOT_NULL)
    private Boolean deleteFlag;

}
