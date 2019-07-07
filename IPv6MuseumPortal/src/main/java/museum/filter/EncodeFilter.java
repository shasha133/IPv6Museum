package museum.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String contentType=request.getHeader("Accept");

        HttpServletResponse response = (HttpServletResponse) servletResponse;


        response.setContentType(contentType == null ? "text/html;charset=UTF-8" : contentType+";charset=UTF-8");

        if(contentType!=null&& contentType.contains("css")){
            response.setHeader("Content-Type","text/css");
        }

        if (request.getMethod().equalsIgnoreCase("POST")) {
            request.setCharacterEncoding("UTF-8");
        }

        if (request.getMethod().equalsIgnoreCase("GET")) {
            //创建request装饰实现类
            request = new HttpServletOfEncode(request,"UTF-8");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
