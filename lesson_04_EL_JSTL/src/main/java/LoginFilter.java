/**
 * @description:filter
 * @author:halation
 * @date:2025/3/23 09:21
 **/
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/stu", "/student.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        if (session.getAttribute("uname") == null){
            req.setAttribute("msg", "请登录后访问！");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);  //放行
    }
}
