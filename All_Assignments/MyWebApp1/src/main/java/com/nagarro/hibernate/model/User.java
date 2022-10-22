package com.nagarro.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable=false)
    private String name;


    @Column(name = "username",unique = true,nullable=false)
    private String username;

    @Column(name = "password",nullable=false)
    private String password;
    
    
    
    

    public User() {
	
	}
	public User(int id, String name, String username, String password) {

		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

