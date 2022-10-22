package com.nagarro.ResultManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studenttable")
public class Student {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int rollno;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "DateOfBirth")
	private String dateofbirth;
	
	@Column(name = "Score")
	private int score;
	
	//we create default constructor because hibernate internally usses default one to create.
	public Student() {
		super();
	}
	
	public Student(int rollno, String name, String dateofbirth, int score) {
		
		this.rollno = rollno;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.score = score;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", dateofbirth=" + dateofbirth + ", score=" + score
				+ "]";
	}
	
	
	
}
