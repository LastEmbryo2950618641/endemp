package cn.personal.endemp.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "MSecurityFilter",urlPatterns = {"/libbox/*"})
public class MSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
//        System.out.println(request.getRequestURI());
//        String url=request.getRequestURI();
 //       System.out.print(url);
        HttpSession session =request.getSession();
        String username= (String) session.getAttribute("username");
        if(username==null)
        {
                try{
                    response.sendRedirect(request.getContextPath()+"/login");}
                catch (Exception e){

                }
            }
            filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
