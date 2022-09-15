package pro.goforit.service;

import com.github.pagehelper.PageInfo;
import pro.goforit.domain.Article;
import pro.goforit.dto.article.ArticleSelectDTO;
import pro.goforit.vo.article.ArticleOverviewVO;

/**
 * @author Double.j
 * @create 2022/8/23 22:01
 * @e-mail zjj20001031@foxmail.com / gugezhang872@gmail.com
 */
public interface IArticleService {


    int insert(Article article);


    PageInfo<ArticleOverviewVO> richSelect(ArticleSelectDTO dto);
}
