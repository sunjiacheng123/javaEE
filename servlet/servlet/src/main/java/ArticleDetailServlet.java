import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServiet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求数据中的id（文章id）
        String id=req.getParameter("id");
        Integer articleId;
        try {
            articleId=Integer.parseInt(id);
        }catch (Exception e){
            throw new ClientException("001","请求参数错误[id="+id+"]");
        }


        Article article=ArticleDAO.query(articleId);
        if(null==article){
            throw new BusinessException("002","查询不到文章详情id="+articleId);
        }
        return article;
        //return Article();//测试代码以后替换为数据库根据文章id查询文章信息操作
    }

    public  static Article testData(){
        Article article=new Article();
        article.setId(1);
        article.setTitle("山东省地方");
        article.setContent("孙菲菲付付");
        article.setUserId(1);
        article.setCreateTime(new Date());
        return article;
    }
}
