package pro.goforit.dto.article;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pro.goforit.dto.BaseSelectDTO;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/25 11:03
 * @desc:
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleSelectDTO extends BaseSelectDTO implements Serializable {
    private static final long serialVersionUID = -3984706622946179617L;

    private String title;

    private String label;

    //空格分割
    private String keywords;

    private Boolean ifReprinted;

    private Boolean ifTop;

    private String createUserId;

}
