package com.cometsale.model;

import org.springframework.security.core.userdetails.User;

import com.cometsale.mongodb.GenericClassDB;

public class StudentLogin {
	private int netid;
	private String password;
	
	public boolean authenicate(int netid, String password) {
		if(this.password == password && this.netid == netid){
			return true;
		}
		else 
			return false;
		
	}
}
