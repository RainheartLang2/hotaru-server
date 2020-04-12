package com.hotaru.core.servlets;

import com.hotaru.core.database.DataSourceFactory;
import com.hotaru.core.database.SessionFactoryHolder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PlatformServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        SessionFactoryHolder.initialize();
        DataSourceFactory.initialize();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        SessionFactoryHolder.destroy();
    }
}
