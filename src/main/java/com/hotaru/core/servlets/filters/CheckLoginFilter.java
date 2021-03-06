package com.hotaru.core.servlets.filters;

import com.hotaru.database.entities.Employee;
import com.hotaru.utils.LoggedInUserHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.NotActiveException;

@WebFilter(filterName = "checkLoginFilter")
public class CheckLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Employee employee = LoggedInUserHelper.getLoggedInEmployee();
        if (employee == null || !employee.isActive() || employee.isDeleted()) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            chain.doFilter(request, response);
        }
    }
}
