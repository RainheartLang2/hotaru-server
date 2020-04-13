package com.hotaru.core.servlets.filters;

import com.hotaru.core.database.SessionFactoryHolder;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "dbTransactionFilter")
public class DBTransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Session session = SessionFactoryHolder.getSession();
        session.beginTransaction();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            session.getTransaction().commit();
        }
    }
}
