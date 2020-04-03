package com.hotaru.core.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHolder {
    private static SessionFactory FACTORY = null;
    private static boolean initialized = false;

    public static void initialize() {
        if (initialized) {
            throw new RuntimeException("Session factory already initialized");
        }

        Configuration configuration = new Configuration().configure();
        FACTORY = configuration.buildSessionFactory();
        initialized = true;
    }

    public static SessionFactory getInstance() {
        if (!initialized) {
            throw new RuntimeException("Session factory not initialized");
        }
        return FACTORY;
    }
}
