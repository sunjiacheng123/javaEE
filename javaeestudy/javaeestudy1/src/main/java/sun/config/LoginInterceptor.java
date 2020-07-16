package sun.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    //controller接收客户端请求，匹配到路径并拦截，进入方法前执行的逻辑
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession(false);//如果没有session，不创建
        if(session!=null){//有登陆
            //权限校验
            //if权限通过
            return true;
            //else
            //response.setStatus(HttpStatus.FORBIDDEN.value());//没权限403
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());//没登录401
        response.sendRedirect("/login.html");

        return false;
    }

    //controller方法执行完，之后的逻辑
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
