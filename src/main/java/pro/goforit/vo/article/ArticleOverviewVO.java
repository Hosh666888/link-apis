package pro.goforit.vo.article;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/25 11:01
 * @desc:
 **/
@Data
public class ArticleOverviewVO implements Serializable {

    private static final long serialVersionUID = 7024923481403565349L;


    private String id;

    private String title;


    private String labels;

    private Collection<String> labelArray;

    private String desc;

    private Boolean ifReprinted;

    private String reprintedUrl;

    private String coverImageUrl;

    private Long heat;

    private String createUser;

    private String createUserRealName;

    private Date createTime;




}
