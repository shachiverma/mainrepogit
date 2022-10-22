package com.nagarro.hibernate.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.nagarro.hibernate.model.Records;
import com.nagarro.hibernate.model.User;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
               settings.put(Environment.URL, "jdbc:mysql://localhost:3306/login?useSSL=false");
               settings.put(Environment.USER, "root");
               settings.put(Environment.PASS, "root");
               settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");
                
               configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Records.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

//            	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
//        		SessionFactory sf = con.buildSessionFactory();
//        		Session session = sf.openSession();
            	
            	
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
	
	
	
}
