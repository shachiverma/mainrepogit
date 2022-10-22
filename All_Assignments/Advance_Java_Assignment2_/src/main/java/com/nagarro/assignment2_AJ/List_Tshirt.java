package com.nagarro.assignment2_AJ;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class List_Tshirt 
{
	public List<Tshirt_table> readDatabase() 
	{ 
		Configuration con = new Configuration().configure().addAnnotatedClass(Tshirt_table.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession(); 
		Transaction tx = null; 
		try { 
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Tshirt_table> list = session.createQuery("from Tshirt_table").list();
		
			tx.commit();
			session.close();
			return list;
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return null;
	}
}
