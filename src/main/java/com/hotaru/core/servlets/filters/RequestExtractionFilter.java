package com.hotaru.core.servlets.filters;

import com.hotaru.core.util.GlobalHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "requestExtractionFilter")
public class RequestExtractionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        GlobalHolder.initialize((HttpServletRequest) servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
