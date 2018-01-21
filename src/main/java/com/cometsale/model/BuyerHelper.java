package com.cometsale.model;

import java.util.ArrayList;

import com.cometsale.mongodb.ProductDB;

public class BuyerHelper {
	
	public void searchItem(String Category){
		
	}
	
	public void displayResults(){
		
	}

	public static ArrayList<Product> fetchBuyerWishList(Student student) {
		return ProductDB.fetchFromIDArray(student.fetchWishListArray());
	}
	
}
