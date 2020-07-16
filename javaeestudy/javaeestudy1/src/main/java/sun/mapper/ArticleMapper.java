package sun.mapper;

import org.apache.ibatis.annotations.Mapper;
import sun.model.Article;

import java.util.List;
@Mapper
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    List<Article> queryByUserId(Integer userId);
}