package pro.goforit.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pro.goforit.conf.ThreadLocalConfig;
import pro.goforit.consts.LogConst;
import pro.goforit.domain.Article;
import pro.goforit.mapper.ArticleMapper;
import pro.goforit.service.IArticleService;
import pro.goforit.utils.IdUtil;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Double.j
 * @create 2022/8/23 22:01
 * @e-mail zjj20001031@foxmail.com / gugezhang872@gmail.com
 */
@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Article article) {
        log.info(LogConst.ENTER_METHOD_LOG,"新增文章",article);
        Assert.notNull(article,"参数不可为空");
        String uuid = IdUtil.getUuid();

        article.setId(uuid);
        Long userId = ThreadLocalConfig.getUserId();

        article.setDeleteFlag(false);
        article.setCreateUser(userId.toString());
        article.setCreateTime(new Date());
        article.setUpdateUser(userId.toString());
        article.setUpdateTime(new Date());
        return articleMapper.insert(article);
    }
}
