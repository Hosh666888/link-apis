package pro.goforit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import pro.goforit.domain.Article;
import pro.goforit.dto.article.ArticleSelectDTO;
import pro.goforit.vo.article.ArticleOverviewVO;

import java.util.Collection;
import java.util.List;

/**
 * @author Double.j
 * @create 2022/8/23 21:59
 * @e-mail zjj20001031@foxmail.com / gugezhang872@gmail.com
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticleOverviewVO> richSelect(ArticleSelectDTO dto);

}
