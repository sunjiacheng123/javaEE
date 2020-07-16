package sun.services;

import org.springframework.stereotype.Service;
import sun.mapper.ArticleMapper;
import sun.model.Article;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;


    public Article queryById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> queryByUserId(Integer userId) {
        return  articleMapper.queryByUserId(userId);
    }
}
