import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServiet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //文章修改，：包含id，title，content
        InputStream is=req.getInputStream();
        Article article= JSONUtil.deserialize(is,Article.class);
        //模拟数据库插入数据操作
        System.out.println("=================\n"+article);
        int num=ArticleDAO.update(article);
        if(num!=1){
            throw  new BusinessException("004","文章修改错误");
        }
        return null;
    }
}
