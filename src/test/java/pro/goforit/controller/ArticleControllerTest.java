package pro.goforit.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.goforit.conf.ThreadLocalConfig;
import pro.goforit.converter.ArticleConverter;
import pro.goforit.domain.Article;
import pro.goforit.domain.user.LoginUser;
import pro.goforit.dto.article.ArticleInsertDTO;
import pro.goforit.dto.article.ArticleSelectDTO;
import pro.goforit.service.IArticleService;
import pro.goforit.utils.IdUtil;
import pro.goforit.vo.article.ArticleDetailVO;
import pro.goforit.vo.article.ArticleOverviewVO;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/9/15 15:57
 * @desc:
 **/
@SpringBootTest
class ArticleControllerTest {

    @Resource
    private IArticleService iArticleService;


    @BeforeEach
    public void test(){
        LoginUser loginUser = new LoginUser();
        loginUser.setId(1556843175833477122L);
        ThreadLocalConfig.set(loginUser);

    }

    @Test
    public void testInsert(){

        ArticleInsertDTO dto = new ArticleInsertDTO();
        dto.setContent("<p>hello world!</p>");
        dto.setRemark("remark");
        dto.setIfReprinted(false);
        dto.setIfTop(false);
        dto.setPlainText("");
        dto.setTitle(IdUtil.getUuid());


        Article article = ArticleConverter.fromInsertDTO(dto);

        iArticleService.insert(article);

    }

    @Test
    public void testDetail(){
        ArticleDetailVO articleDetailVO = iArticleService.selectDetailById("4b3dc09610674ab5a03aab1fce21f3c9");
        System.out.println(articleDetailVO);
    }


    @Test
    public void testRichSelect(){

        ArticleSelectDTO dto = new ArticleSelectDTO();
        for (ArticleOverviewVO item : iArticleService.richSelect(dto).getList()) {
            System.out.println(item);
        }


    }
}