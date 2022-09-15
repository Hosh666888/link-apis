package pro.goforit.vo.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pro.goforit.domain.Article;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/9/15 11:27
 * @desc:
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleDetailVO extends Article implements Serializable {
    private static final long serialVersionUID = 7113728515116388940L;

    private String createUserRealName;




}
