package pro.goforit.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import pro.goforit.conf.ThreadLocalConfig;
import pro.goforit.domain.Article;
import pro.goforit.dto.article.ArticleInsertDTO;
import pro.goforit.utils.IdUtil;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/25 10:46
 * @desc:
 **/
public class ArticleConverter {

    public static Article fromInsertDTO(ArticleInsertDTO dto){

        Article article = new Article();
        BeanUtils.copyProperties(dto,article,"labels");

        if (!CollectionUtils.isEmpty(dto.getLabels())){
            StringJoiner joiner = new StringJoiner(",");
            dto.getLabels().forEach(joiner::add);
            article.setLabels(joiner.toString());
        }



        return article;
    }


}
