package com.hotaru.core.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "corsFilter")
public class CORSFilter implements Filter {

    private static final String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";
    private static final String ALLOWED_HEADERS_HEADER = "Access-Control-Allow-Headers";
    private static final String ALLOWED_METHODS_HEADER = "Access-Control-Allow-Methods";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader(ALLOWED_METHODS_HEADER, "GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD");
        response.addHeader(ALLOWED_HEADERS_HEADER, "origin, content-type, accept, authorization");

        response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");

        filterChain.doFilter(servletRequest, servletResponse);
   }
}
