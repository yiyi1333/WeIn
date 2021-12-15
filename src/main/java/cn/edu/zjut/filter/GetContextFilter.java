package cn.edu.zjut.filter;

import cn.edu.zjut.po.SysContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hydrogen_zyx
 */
public class GetContextFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SysContext.setRequest((HttpServletRequest) request);
        SysContext.setResponse((HttpServletResponse) response);
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}

