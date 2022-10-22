package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {

	private Configuration con;
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	public void saveData(User user) 
	{
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session.save(user);
		t.commit();
		
	}

	public List displayData() {
		
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		
		List list = session.createQuery("From User").list();
		return list;
	}

	public List searchData(User u) {
		
		List li = new ArrayList();
		
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		
		List list = session.createQuery("From User").list();
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			User ud = (User)it.next();
			if((u.getId()==ud.getId()) || (u.getUsername().equalsIgnoreCase(ud.getUsername())) ||
					(u.getPassword().equalsIgnoreCase(ud.getPassword())) )
			{
				User obj = new User();
				
				obj.setId(ud.getId());
				
				obj.setUsername(ud.getUsername());
				
				obj.setPassword(ud.getPassword());
				
				li.add(obj);
			}
		}
		
		
		return li;
	}

	public boolean login(User u) {
		
		boolean flag = false;
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		List lis = session.createQuery("From User").list();
		Iterator it = lis.iterator();
		while(it.hasNext())
		{
			User obj = (User)it.next();
			if(obj.getUsername().equals(u.getUsername()) && obj.getPassword().equals(u.getPassword()))
			{
				flag = true;
			}
		}
		
		
		return flag;
	}

}
