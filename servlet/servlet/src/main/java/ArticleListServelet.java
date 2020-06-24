import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServelet extends AbstractBaseServiet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) {
        List<Article> articles= ArticleDAO.list();
        //return testDate();
        return articles;
    }

//    public static List<Article> testDate(){
//        List<Article> articles=new ArrayList<>();
//        Article a1=new Article();
//        a1.setId(3);
//        a1.setTitle("sdddd");
//        a1.setContent("是大V从v");
//        a1.setUserId(1);
//        a1.setCreateTime(new Date());
//        Article a2=new Article();
//        a2.setId(2);
//        a2.setTitle("山东省地方");
//        a2.setContent("孙菲菲付付");
//        a2.setUserId(1);
//        a2.setCreateTime(new Date());
//        articles.add(a1);
//        articles.add(a2);
//        return articles;
//    }
}
