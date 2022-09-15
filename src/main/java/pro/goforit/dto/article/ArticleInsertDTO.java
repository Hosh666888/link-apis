package pro.goforit.dto.article;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/25 10:44
 * @desc:
 **/
@Data
public class ArticleInsertDTO implements Serializable {
    private static final long serialVersionUID = -7658174926577221734L;


    @NotBlank(message = "请输入标题")
    private String title;

    private Collection<String> labels;

    @NotBlank(message = "请输入正文")
    private String content;

    @NotBlank(message = "请传递原始正文")
    private String plainText;


    private Boolean ifReprinted;

    private String reprintedUrl;

    private Boolean ifTop;

    private String coverImageUrl;

    private String remark;



}
