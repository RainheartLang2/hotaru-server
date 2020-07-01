package com.hotaru.core.servlets;

import com.hotaru.business.logic.Settings;
import com.hotaru.business.managers.DemoDataManager;
import com.hotaru.business.managers.SettingsManager;
import com.hotaru.core.database.DataSourceFactory;
import com.hotaru.core.database.SessionFactoryHolder;
import com.hotaru.core.exceptions.ValidationException;
import org.hibernate.Session;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PlatformServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        SessionFactoryHolder.initialize();
//        DataSourceFactory.initialize();

    }

    public void contextDestroyed(ServletContextEvent sce) {
        SessionFactoryHolder.destroy();
    }
}
