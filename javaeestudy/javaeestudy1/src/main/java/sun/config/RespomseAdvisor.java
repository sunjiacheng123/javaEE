package sun.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import sun.model.Response;

@ControllerAdvice
public class RespomseAdvisor implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //返回true，表示响应数据事，先执行beforeBodyWrite，false不执行
        //获取请求方法对象，判断controller方法上是否有@ResponseBody
        return methodParameter.getMethod().getAnnotation(ResponseBody.class)!=null;
    }

    //o为请求方法执行完以后，返回的对象
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Response resp=new Response();
        resp.setSuccess(true);
        resp.setData(o);
        return resp;
    }
}
