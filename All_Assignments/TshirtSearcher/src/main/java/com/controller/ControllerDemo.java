package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.model.User;
import com.model.UserDao;
import com.model.Tshirt_table;
import com.model.Tshirt_tableDao;

@Controller
public class ControllerDemo 
{
	
	static private Configuration con;
	static private SessionFactory factory;
	static private Session session;
	static private Transaction t;
	
	
	private ApplicationContext conn;
	
	@RequestMapping("/login")
	public String view1(Model m)
	
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		User u = conn.getBean("info", User.class);
		m.addAttribute("bean",u);
		return "login";
	}
	
	@RequestMapping("/signin")
	public String login(@ModelAttribute("bean") User u, HttpServletRequest request ) {
		
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDao ud = conn.getBean("dao", UserDao.class);
		boolean flag=ud.login(u);
		if(flag)
		{
			User usr= conn.getBean("info", User.class);
			usr.setUsername(u.getUsername());
			usr.setPassword(u.getPassword());
			usr.setFlag(1);
			HttpSession session = request.getSession();
			session.setAttribute("data", usr);
			return "home";
		}
		else {
			return "redirect:index.jsp";
		}
	}
	
	@RequestMapping("/register")
	public String view2(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		User u = conn.getBean("info", User.class);
		m.addAttribute("bean",u);
		return "register";
	}
	
	@RequestMapping("/store")
	public String view3(@ModelAttribute("bean") User user , Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDao ud = conn.getBean("dao", UserDao.class);
		ud.saveData(user);
		m.addAttribute("msg", "Record inserted successfully");
		return "register";
	}
	
	@RequestMapping("/display")
	public String view4(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDao ud = conn.getBean("dao", UserDao.class);
		List list = ud.displayData();
		if(!list.isEmpty()) {
		m.addAttribute("data",list);}
		else {
			m.addAttribute("msg","Data not found!");
		}
		return "display";
	}
	
	@RequestMapping("/find")
	public String view5(Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		User u = conn.getBean("info", User.class);
		m.addAttribute("bean",u);
		return "search";
	}
	
	@RequestMapping("/search")
	public String view6(@ModelAttribute("bean") User u, Model m) {
		
		conn = new  ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDao ud = conn.getBean("dao",UserDao.class);
		
		List list = ud.searchData(u);
		if(!list.isEmpty()) {
			m.addAttribute("li",list);
		}
		else {
			m.addAttribute("msg", "Sorry no such record found!");
		}
		return "search";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User obj = (User)session.getAttribute("data");
		obj.setFlag(0);
		return "redirect:index.jsp";
	}
	
	//shirts
	
	
	@RequestMapping("/storetshirt")
	public String view9(@ModelAttribute("bean") Tshirt_table tt , Model m) throws InterruptedException
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Tshirt_tableDao ttabled = conn.getBean("shirtdao", Tshirt_tableDao.class);
		ttabled.saveTshirtData(tt);
		//m.addAttribute("msg", "Record inserted successfully");
		return "storetshirt";
	}
	
	@RequestMapping("/findshirt")
	public String view7(Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Tshirt_table tt = conn.getBean("modelshirt", Tshirt_table.class);
		m.addAttribute("bean",tt);
		return "searchtshirt";
	}
	
	
	@RequestMapping("/searchtshirt")
	public String searchtshirts(@ModelAttribute("bean") Tshirt_table table, Model m)
	{
		
			conn = new  ClassPathXmlApplicationContext("ApplicationContext.xml");
			Tshirt_tableDao tabled = conn.getBean("shirtdao",Tshirt_tableDao.class);
			
			
			List list = tabled.searchTshirtData(table);
			if(!list.isEmpty()) {
				
				m.addAttribute("li",list);
				
				
			}
			else {
				m.addAttribute("msg", "Sorry we dont have this type of t-shirt!");
			}
			return "searchtshirt";
	}

}
	
	

