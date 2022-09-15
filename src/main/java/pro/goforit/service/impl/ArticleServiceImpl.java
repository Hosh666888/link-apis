package pro.goforit.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import pro.goforit.conf.ThreadLocalConfig;
import pro.goforit.consts.LogConst;
import pro.goforit.domain.Article;
import pro.goforit.dto.article.ArticleSelectDTO;
import pro.goforit.exceptions.NotFoundException;
import pro.goforit.mapper.ArticleMapper;
import pro.goforit.service.IArticleService;
import pro.goforit.service.IUserService;
import pro.goforit.utils.IdUtil;
import pro.goforit.utils.PageUtil;
import pro.goforit.utils.Tuple2;
import pro.goforit.vo.article.ArticleDetailVO;
import pro.goforit.vo.article.ArticleOverviewVO;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private IUserService iUserService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Article article) {
        log.info(LogConst.ENTER_METHOD_LOG,"新增文章",article);
        Assert.notNull(article,"参数不可为空");
        String uuid = IdUtil.getUuid();

        article.setId(uuid);
        Long userId = ThreadLocalConfig.getUserId();

        article.setDeleteFlag(false);
        article.setCreateUser(userId);
        article.setCreateTime(new Date());
        article.setUpdateUser(userId);
        article.setUpdateTime(new Date());
        return articleMapper.insert(article);
    }

    @Override
    public PageInfo<ArticleOverviewVO> richSelect(ArticleSelectDTO dto) {
        if (dto==null){
            dto = new ArticleSelectDTO();
        }

        Tuple2<Integer, Integer> tuple = PageUtil.getReasonablePageParam(dto.getPageIndex(), dto.getPageSize());
        PageMethod.startPage(tuple.left,tuple.right);
        List<ArticleOverviewVO> list = articleMapper.richSelect(dto);
        PageInfo<ArticleOverviewVO> of = PageInfo.of(list);

        of.getList().forEach(item->{
            if (StringUtils.hasText(item.getLabels())){
                ArrayList<String> strings = new ArrayList<>(4);
                String[] split = item.getLabels().split(",");
                strings.addAll(Arrays.asList(split));
                item.setLabelArray(strings);
            }
        });

        return of;

    }

    @Override
    @SneakyThrows
    public ArticleDetailVO selectDetailById(String id) {
        log.info(LogConst.ENTER_METHOD_LOG,"查询文章详情",id);
        ArticleDetailVO origin = articleMapper.selectDetailById(id);
        if (origin==null){
            throw new NotFoundException(id);
        }
        return origin;

    }
}
