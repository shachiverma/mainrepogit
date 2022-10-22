package com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Tshirt_tableDao {

	private Configuration con;
	private SessionFactory factory;
	private Session session;
	private Transaction t;
	
	//private static final String src_dir="src/main/java/resources";
	//private static ArrayList<String> list_of_file = new ArrayList<String>();
	
	//static ArrayList<String> csv_data = new ArrayList<String>();
	//static ArrayList<String> arr;
	
	public void saveTshirtData(Tshirt_table tt) 
	{
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		session.save(tt);
		t.commit();
	}	
	
//		try 
//		 {
//	            File folder = new File(src_dir);
//	            for (File file : folder.listFiles()) 
//	            {
//	                String name = file.getName();
//	                if (!list_of_file.contains(name)) 
//	                {
//	                	list_of_file.add(name);
//	                }
//	            }
//	     } 
//		 catch (Exception e) 
//		 {
//	            e.printStackTrace();
//	     }
//		
//		if (list_of_file.size() > 0)
//		{
//			//create BufferedReader to read csv file
//			for (int i = 0; i < list_of_file.size(); i++ )
//			{
//				try {					
//					BufferedReader br = new BufferedReader(new FileReader(src_dir+"/"+list_of_file.get(i)));
//					
//					String str_line ="";
//					br.readLine();
//					while((str_line = br.readLine()) != null) {
//						
//						if (!csv_data.contains(str_line)) 
//		                {
//							StringTokenizer token = new StringTokenizer(str_line, "|");
//			                arr = new ArrayList<String>(str_line.length());
//			                while (token.hasMoreTokens()) {
//			                    arr.add(token.nextToken());
//			                }
//			                Object[] objArr = arr.toArray();
//			                
//			                
//			                // convert Object array to String array
//			                String[] str = Arrays.copyOf(objArr, objArr.length,String[].class);
//			                
//			                
//			                
//			                Tshirt_table row = new Tshirt_table();
//							row.setTshirt_id(str[0]);
//							row.setTshirt_name(str[1]);
//							row.setTshirt_colour(str[2]);
//							row.setGender_choice(str[3]);
//							row.setSize_choice(str[4]);
//							row.setTshirt_price(Double.parseDouble(str[5]));
//							row.setTshirt_rating(Float.parseFloat(str[6]));
//							row.setTshirt_available(str[7]);
//									     
//							
//							con = new Configuration().configure("hibernate.cfg.xml");
//							factory = con.buildSessionFactory();
//							session = factory.openSession();
//							t = session.beginTransaction();
//							session.save(row);
//							t.commit();
//							
//							csv_data.add(str_line);
//		                }
//						}
//				}
//				catch(Exception e)
//				{
//					System.out.println(e.getMessage());
//					System.out.println("Error occurs");
//				}		
//			}	
//		}
//		
//	}
//
//	
	

	public List searchTshirtData(Tshirt_table tt) {
		
		List li = new ArrayList();
		
		con = new Configuration().configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
		
		List list = session.createQuery("From Tshirt_table").list();
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			Tshirt_table ttable = (Tshirt_table)it.next();
			if((ttable.getTshirt_colour().equalsIgnoreCase(tt.getTshirt_colour())) &&
					(ttable.getGender_choice().equalsIgnoreCase(tt.getGender_choice()) &&
							(ttable.getSize_choice().equalsIgnoreCase(tt.getSize_choice()) && 
									(ttable.getTshirt_available().equals("Y")))))
			{
				Tshirt_table obj = new Tshirt_table();
				
				
				obj.setTshirt_colour(ttable.getTshirt_colour());
				
				obj.setGender_choice(ttable.getGender_choice());
				
				obj.setSize_choice(ttable.getSize_choice());
				
				obj.setTshirt_id(ttable.getTshirt_id());
				
				obj.setTshirt_name(ttable.getTshirt_name());
				
				obj.setTshirt_price(ttable.getTshirt_price());
				
				obj.setTshirt_rating(ttable.getTshirt_rating());
				
				obj.setTshirt_available(ttable.getTshirt_available());
				
				li.add(obj);
			}
		}
		
		return li;
	}
	
	
}