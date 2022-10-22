package com.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ArrayListData extends Thread
{
	
	private static Configuration con;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction t;
	
	private static final String src_dir="src/main/java/resources";
	private static ArrayList<String> list_of_file = new ArrayList<String>();
	
	static public ArrayList<String> getAllFiles()
	{
		 try 
		 {
	            File folder = new File(src_dir);
	            for (File file : folder.listFiles()) 
	            {
	                String name = file.getName();
	                if (!list_of_file.contains(name)) 
	                {
	                	list_of_file.add(name);
	                }
	            }
	     } 
		 catch (Exception e) 
		 {
	            e.printStackTrace();
	     }
	        return list_of_file;
	        
	
	
	}
	
	static ArrayList<String> csv_data = new ArrayList<String>();
	static ArrayList<String> arr;
    static public ArrayList<String> readCSV()
	{
		if (list_of_file.size() > 0)
		{
			//create BufferedReader to read csv file
			for (int i = 0; i < list_of_file.size(); i++ )
			{
				try {					
					BufferedReader br = new BufferedReader(new FileReader(src_dir+"/"+list_of_file.get(i)));
					
					String str_line ="";
					br.readLine();
					while((str_line = br.readLine()) != null) {
						
						if (!csv_data.contains(str_line)) 
		                {
							StringTokenizer token = new StringTokenizer(str_line, "|");
			                arr = new ArrayList<String>(str_line.length());
			                while (token.hasMoreTokens()) {
			                    arr.add(token.nextToken());
			                }
			                Object[] objArr = arr.toArray();
			                
			                
			                // convert Object array to String array
			                String[] str = Arrays.copyOf(objArr, objArr.length,String[].class);
			                
			                
			                
			                Tshirt_table row = new Tshirt_table();
							row.setTshirt_id(str[0]);
							row.setTshirt_name(str[1]);
							row.setTshirt_colour(str[2]);
							row.setGender_choice(str[3]);
							row.setSize_choice(str[4]);
							row.setTshirt_price(Double.parseDouble(str[5]));
							row.setTshirt_rating(Float.parseFloat(str[6]));
							row.setTshirt_available(str[7]);
							
				                
//				          	Session session = HibernateUtil.getSessionFactory().openSession();
//				          	Transaction tnx = session.beginTransaction();
//			                
//			          	  
//			          	    session.save(row);
//			          	    tnx.commit();
//			     
							
							
							
							con = new Configuration().configure("hibernate.cfg.xml");
							factory = con.buildSessionFactory();
							session = factory.openSession();
							t = session.beginTransaction();
							session.save(row);
							t.commit();
							
							csv_data.add(str_line);
		                }
						}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println("Error occurs");
				}		
			}	
		}
		return csv_data;
	}
	
	public static ArrayList<String> getCSVData()
	{
		return csv_data;
	}
	@Override
	public void run()
	{
		while(true)
		{
			getAllFiles();
			readCSV();
			try
			{
				Thread.sleep(10000);//sleep for 10 second
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}	
	
}	
