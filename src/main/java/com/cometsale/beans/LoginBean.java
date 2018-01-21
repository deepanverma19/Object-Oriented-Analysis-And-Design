package com.cometsale.beans;

//TODO: change to studentLogin.
public class LoginBean {

	private String netID;
	private String password;
    /**
     * Default constructor. 
     */
    public LoginBean() {
    	netID = "";
    	password = "";
    }
	
	public String getNetID() {
		return netID;
	}
	
	public void setNetID(String netID) {
		this.netID = netID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
