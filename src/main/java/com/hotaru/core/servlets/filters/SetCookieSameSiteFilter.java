package com.hotaru.core.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "sameSiteFilter")
public class SetCookieSameSiteFilter implements Filter {
    private static final String SET_COOKIE_HEADER = "Set-Cookie";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader(SET_COOKIE_HEADER, response.getHeader(SET_COOKIE_HEADER) + ";SameSite=None");
        chain.doFilter(servletRequest, servletResponse);
    }
}
