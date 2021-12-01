package com.project.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonConnection {
    private static SessionFactory sessionFactory;

    public SingletonConnection() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
