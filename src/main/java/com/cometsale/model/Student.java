package com.cometsale.model;

import java.util.ArrayList;
import java.util.List;

import com.cometsale.mongodb.UserDB;

public class Student {

	String netId;
	WishList wishList;
	public StudentDetails details;
	
	public Student(){
		this.wishList=new WishList();
		this.details=new StudentDetails();
	}
	
	public String getNetid() {
		return netId;
	}

	public void setNetid(String string) {
		this.netId = string;
	}
	
	public WishList getWishList() {
		return wishList;
	}
	
	public ArrayList<String> fetchWishListArray() {
		return wishList.getIntresetedProduct();
	}
	
		
	
	public void setWishList(WishList wishList) {
		this.wishList=wishList;
	}
	
	public void addProductToWishlist(Product p) {
		this.wishList.addProduct(p);
		UserDB.updateWishList(this);
	}
	
	public void removeProductFromWishlist(Product p) {
		this.wishList.removeProduct(p);
		UserDB.updateWishList(this);
	}
	
//	public List<History> getBuyerHistories(){
//		return null;
//	}
//	
//	public List<History> getSellerHistories(){
//		return null;
//	}

}
