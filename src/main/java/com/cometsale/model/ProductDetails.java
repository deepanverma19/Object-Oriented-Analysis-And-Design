package com.cometsale.model;

import java.util.List;
import java.util.UUID;

import com.cometsale.mongodb.ProductDB;

public class ProductDetails {

	String productName;
	Student seller;
    byte[] imageBytes;
	String productDesc;
	double offerPrice;
	String status; //values: sold, available, locked.
	String quality;
	Address pickupAddress;
	String category;
	

	
	public byte[] getImageBytes(){
		return imageBytes;
	}
	
	public void setImageBytes(byte[] inputImageBytes){
		this.imageBytes=inputImageBytes;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productname) {
		this.productName = productname;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Address getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Student getSeller() {
		return seller;
	}
	public void setSeller(Student seller) {
		this.seller = seller;
	}

	public String toString() {
 		String printString;
 		
 		printString = "productName : "+ getProductName() +
 					  "\nproductDescription : " + getProductDesc() +
 					  "\nstatus:"+ getStatus()+"\n";

 		return printString;
		
 		
 	}
}
