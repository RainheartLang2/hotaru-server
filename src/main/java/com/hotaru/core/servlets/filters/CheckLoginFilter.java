package com.hotaru.core.servlets.filters;

import com.hotaru.core.util.CommonConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.NotActiveException;

@WebFilter(filterName = "checkLoginFilter")
public class CheckLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getSession().getAttribute(CommonConstants.LOGGED_IN_USER_ATTRIBUTE) == null) {
            throw new NotActiveException();
        }
        chain.doFilter(request, response);
    }
}
