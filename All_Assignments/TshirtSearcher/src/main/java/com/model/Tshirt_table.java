package com.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Tshirt_table {

	@Id

	String tshirt_id;
	String tshirt_name;
	String tshirt_colour;
	String gender_choice;
	String size_choice;
	Double tshirt_price;
	Float tshirt_rating;
	String tshirt_available;

	

	public Tshirt_table(String tshirt_id, String tshirt_name, String tshirt_colour, String gender_choice,
			String size_choice, Double tshirt_price, Float tshirt_rating, String tshirt_available) {
		super();
		this.tshirt_id = tshirt_id;
		this.tshirt_name = tshirt_name;
		this.tshirt_colour = tshirt_colour;
		this.gender_choice = gender_choice;
		this.size_choice = size_choice;
		this.tshirt_price = tshirt_price;
		this.tshirt_rating = tshirt_rating;
		this.tshirt_available = tshirt_available;
	}

	public Tshirt_table() {
		
	}

	public String getTshirt_id() {

		return tshirt_id;
	}

	public void setTshirt_id(String tshirt_id) {

		this.tshirt_id = tshirt_id;
	}

	public String getTshirt_name() {

		return tshirt_name;
	}

	public void setTshirt_name(String tshirt_name) {

		this.tshirt_name = tshirt_name;
	}

	public String getTshirt_colour() {

		return tshirt_colour;
	}

	public void setTshirt_colour(String tshirt_colour) {

		this.tshirt_colour = tshirt_colour;
	}

	public String getGender_choice() {

		return gender_choice;
	}

	public void setGender_choice(String gender_choice) {

		this.gender_choice = gender_choice;
	}

	public String getSize_choice() {

		return size_choice;
	}

	public void setSize_choice(String size_choice) {

		this.size_choice = size_choice;
	}

	public Double getTshirt_price() {

		return tshirt_price;
	}

	public void setTshirt_price(Double tshirt_price) {

		this.tshirt_price = tshirt_price;
	}

	public Float getTshirt_rating() {

		return tshirt_rating;
	}

	public void setTshirt_rating(Float tshirt_rating) {

		this.tshirt_rating = tshirt_rating;
	}

	public String getTshirt_available() {

		return tshirt_available;
	}

	public void setTshirt_available(String tshirt_available) {

		this.tshirt_available = tshirt_available;
	}

	

	
	public String toString() {
	return "Tshirt_table [" +tshirt_id +" | "  + tshirt_name + " | "+ 
				 tshirt_colour + " | "+ gender_choice+" | " + size_choice+" | "+
				 tshirt_price + " | " + tshirt_rating + " | "
				+ tshirt_available + "]";
	}

	

}

