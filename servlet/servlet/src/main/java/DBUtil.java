import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/blogdemo";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    //单例模式：双重校验锁
    //面试怎么考?
    //1.编码写出来
    //2.谈谈单例的实现：
    //         非线程安全：饿汉式，懒汉式，
    //         线程安全：双重校验锁，静态内部类，匿名内部类
    //3.线程安全的单例模式，把代码表达出来
    //         只需要说双重校验锁的代码就行：
    //         （1）DCL（双重校验锁），
    //         （2）两次null判断，第一次保证效率，第二次保证同一个对象
    //         （3）中间使用synchronized加锁，共享变量使用
    //         （4）共享变量使用volatile保证可见性，禁止指令重排序--->具体volatile的细节
    //
    //4.双重校验锁内部的细节：两次判断，一次加锁，变量使用volatile，每个地方都要知道为什么

    private static volatile DataSource DS;

    private static DataSource getDataSource() {
        if(DS==null){
            synchronized (DBUtil.class){
                if(DS==null){
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setUrl(URL);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw  new SystemEexception("000","获取数据库连接失败",e);
        }
    }

    //插入/修改/删除不需要释放resultset
    public static void close(Connection c,Statement s){
        close(c,s,null);
    }

    //释放资源操作：数据库服务请求/响应也是基于网络数据传输的，也就是网络IO
    //需要在使用完以后释放资源
    public static void close(Connection c, Statement s, ResultSet r){

        try{
            if(c!=null){
                c.close();
            }
            if(s!=null){
                s.close();
            }
            if(r!=null){
                r.close();
            }
        } catch (SQLException e) {
            throw new SystemEexception("000","释放数据库资源失败",e);
        }
    }


}

