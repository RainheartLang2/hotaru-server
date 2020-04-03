package com.hotaru.core.servlets.filters;

import com.hotaru.core.database.SessionFactoryHolder;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@WebFilter(filterName = "dbTransactionFilter")
public class DBTransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SessionFactoryHolder.getInstance().getCurrentSession().beginTransaction();
        filterChain.doFilter(servletRequest, servletResponse);
        SessionFactoryHolder.getInstance().getCurrentSession().getTransaction().commit();
    }

    @Override
    public void destroy() {}
}
