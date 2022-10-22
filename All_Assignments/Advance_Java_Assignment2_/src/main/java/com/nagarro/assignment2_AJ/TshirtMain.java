package com.nagarro.assignment2_AJ;

import java.io.FileNotFoundException;
import java.util.*;

public class TshirtMain {
	
	

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		//object for getting data from arraylistdata class
		
		
		ArrayListData thread = new ArrayListData();
		
		thread.start();
		   
	    Thread.sleep(3000);
		
		Scanner scan = new Scanner(System.in);
		String colour , size, gender;
		int preference;
		
		
		 
		
		System.out.println("Enter Colour of the Tshirt");
		colour = scan.nextLine().toUpperCase();
		
		System.out.println("Enter Gender as M-Male/F-Female/U-Unisex");
		gender = scan.nextLine().toUpperCase();
		
		
		System.out.println("Enter Size of the Tshirt as S/M/L/XL/XXL");
		size = scan.nextLine().toUpperCase();
		
		
		System.out.println("Enter Output Preference \n1.Price\n2.Rating\n3.Price & Rating");
		preference = scan.nextInt();
		
		
		
		Tshirt_table table = new Tshirt_table();
		List_Tshirt dao = new List_Tshirt();
		List<Tshirt_table> list = dao.readDatabase();
		for(Tshirt_table iter:list) {
			
			if(iter.getTshirt_colour().equalsIgnoreCase(colour) && iter.getGender_choice().equalsIgnoreCase(gender) 
					&& iter.getSize_choice().equalsIgnoreCase(size) && iter.getTshirt_available().equals("Y")) 
			{
			System.out.println(iter.toString());
			}
			
		}
		if(list.isEmpty()) 
		{
			System.out.println("Sorry we do not have Tshirt of this type!");
		}
		scan.close();
	}
		
	 
		
		
		
		
		
		
		
	}



