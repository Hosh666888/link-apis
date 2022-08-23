package pro.goforit.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Double.j
 * @create 2022/8/23 21:52
 * @e-mail zjj20001031@foxmail.com / gugezhang872@gmail.com
 */
@Data
public class Article implements Serializable {

    private String id;

    private String title;

    private String content;

    private String plainText;

    private Boolean ifReprinted;

    private String reprintedUrl;

    private Boolean ifTop;

    private String coverImageUrl;

    private String remark;

    private Long heat;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;


    private Boolean deleteFlag;


}
