package com.limingxuan.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Creqated by Limingxuan on 2021/2/27
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //让过滤器继续往下放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
