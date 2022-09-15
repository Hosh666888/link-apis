package pro.goforit.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.goforit.converter.ArticleConverter;
import pro.goforit.domain.Article;
import pro.goforit.domain.returns.R;
import pro.goforit.dto.article.ArticleInsertDTO;
import pro.goforit.dto.article.ArticleSelectDTO;
import pro.goforit.service.IArticleService;
import pro.goforit.vo.article.ArticleOverviewVO;

import javax.annotation.Resource;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/25 10:43
 * @desc:
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private IArticleService articleService;

    @PostMapping("insert")
    public R<String> insert(@RequestBody @Validated ArticleInsertDTO dto){
        Article article = ArticleConverter.fromInsertDTO(dto);
        articleService.insert(article);
        return R.success();
    }

    @PostMapping("/select")
    public R<PageInfo<ArticleOverviewVO>> selectOverview(@RequestBody ArticleSelectDTO dto){
        PageInfo<ArticleOverviewVO> result = articleService.richSelect(dto);
        return R.success(result);
    }

}
