package com.cometsale.uimodel;

public class UserResponseModel extends ResponseModel {
	
	int userid ; 
	String username ;
	
	public UserResponseModel() {
		super();
		
		
	}
	public void setDefaultValue() {
		super.setDefaultValue();
		// Default.
		this.userid =0;
		this.username = "";		 
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

	
	
}
