package com.hotaru.core.servlets.filters;

import com.hotaru.core.database.SessionFactoryHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "dbTransactionFilter")
public class DBTransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SessionFactoryHolder.getInstance().getCurrentSession().beginTransaction();
        filterChain.doFilter(servletRequest, servletResponse);
        SessionFactoryHolder.getInstance().getCurrentSession().getTransaction().commit();
    }
}
