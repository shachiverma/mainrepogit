package com.nagarro.assignment2_AJ;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;




public class HibernateUtil {
	
	 
	 private static SessionFactory sessionFactory;
	 
 

	 public static SessionFactory getSessionFactory()
	 {
	 
	
		 if(sessionFactory == null)
		 {
			Configuration configuration=new Configuration().configure().addAnnotatedClass(Tshirt_table.class);
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
			 
		 }
		 
		
		 return sessionFactory;
	 }
}