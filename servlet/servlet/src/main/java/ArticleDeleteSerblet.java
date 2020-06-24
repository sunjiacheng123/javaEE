import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/articleDelete")
public class ArticleDeleteSerblet extends AbstractBaseServiet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       //ids=1,2,3
        String idsString=req.getParameter("ids");
        int[] ids=parseIds(idsString);
        int num=ArticleDAO.delete(ids);
        if(num==0){
            throw new BusinessException("005","文章删除出错");
        }
        //把ids传到数据库做删除操作
        return null;
    }

    public static int[] parseIds(String idsString){
        String[] idsArray=idsString.split(",");//["1","2","3"]
        int[] ids=new int[idsArray.length];
        for(int i=0;i<idsArray.length;i++){
            ids[i]=Integer.parseInt(idsArray[i]);
        }
        return ids;
    }
}
