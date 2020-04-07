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
        try (Session session = SessionFactoryHolder.getInstance().getCurrentSession()) {
            session.beginTransaction();
            filterChain.doFilter(servletRequest, servletResponse);
            session.getTransaction().commit();
        }
    }
}
