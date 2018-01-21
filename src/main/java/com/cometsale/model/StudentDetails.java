package com.cometsale.model;

import java.util.Date;

public class StudentDetails {
    private String  firstName;
    private String  lastName;
    private String  phoneNumber;
    private Address homeAddress;
    private String email;
       

	public StudentDetails(){}
    
    public StudentDetails(String Username,String FirstName,String LastName){
        this.firstName=FirstName;
        this.lastName=LastName;
    }

//	public String getPassword() {
//	//	return password;S
//	}
//
//	public void setPassword(String password) {
//	//	this.password = password;
//	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	
    
//    public String getUserName(){
//        return userName;
//    }
//    
//    public void setUserName(String UserName){
//        this.userName=UserName;
//    } 
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String FirstName){
        this.firstName=FirstName;
    } 
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String LastName){
        this.lastName=LastName;
    }
    
    public String getEmail() {
 		return email;
 	}

 	public void setEmail(String email) {
 		this.email = email;
 	}
 	
 	public String toString() {
 		String printString;
 		
 		printString = //			" userName : "+ userName +
 				" firstName : " + firstName +
 				" lastName :" + lastName +
 	//			" password :"+ password +
 				" phoneNumber :" + phoneNumber +
 				" homeAddress :" + homeAddress +
 				 homeAddress.getAptNo() +
 				 homeAddress.getCity()+
 				 homeAddress.getPinCode()+
 				 homeAddress.getStreetname() +
 				 homeAddress.getState() +
 				 " email :"+ email ;
 		return printString;
		
 		
 	}

    
}
