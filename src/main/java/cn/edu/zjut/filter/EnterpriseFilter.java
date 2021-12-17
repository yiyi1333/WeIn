package cn.edu.zjut.filter;

import cn.edu.zjut.po.SysContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;


/**
 * @author hydrogen_zyx
 */
public class EnterpriseFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("execute --doFilter()");
        HttpServletRequest httpRequest = (HttpServletRequest)request;

        HttpSession session = httpRequest.getSession();
        if (!Objects.equals(session.getAttribute("type"), new String("enterpriseAgency"))) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
