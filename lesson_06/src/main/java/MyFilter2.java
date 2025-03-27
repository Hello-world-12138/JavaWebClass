import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @description:2
 * @author:halation
 * @date:2025/3/23 08:57
 **/
@WebFilter("/b")
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器被初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器逻辑执行");

        filterChain.doFilter(servletRequest, servletResponse);  //放行
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}

