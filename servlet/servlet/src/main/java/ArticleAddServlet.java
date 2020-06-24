import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServiet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        InputStream is=req.getInputStream();
        //http请求content-type为application、json，请求体是接送字符串，需要反序列化为java对象
        //需要检查接送字符串的键，笔芯和java类型中的属性，能匹配
        //如果json中的字段在java类中没有，就抛异常
        //文章新增：包含title，content，userAccout
        Article article= JSONUtil.deserialize(is,Article.class);
        int num=ArticleDAO.insert(article);
        if(num !=1){
            throw new BusinessException("001","插入文章错误");
        }
        //模拟数据库插入数据操作
        System.out.println("=================\n"+article);
        return null;
    }
}
