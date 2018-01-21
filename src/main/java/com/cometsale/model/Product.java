package com.cometsale.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cometsale.mongodb.ProductDB;

public class Product {
	
	String productId;
	Student seller;
	ArrayList<Offer> offers;
	ProductDetails details;
	ProductStatus status;
	
	public Product(){
		 String uuid = UUID.randomUUID().toString();
		 while(ProductDB.productIDinDB(uuid)) {
			 uuid = UUID.randomUUID().toString();
		 } 
		 setProductId(uuid);
		 setStatus(ProductStatus.open);
		 details=new ProductDetails();
		 offers=new ArrayList<Offer>();
	}
	
	
	//getter and setters
	public String getProductId() {
		return productId;	
	}
	public void setProductId(String uuid) {
		this.productId = uuid;
	}
	public Student getSeller() {
		return seller;
	}
	public void setSeller(Student seller) {
		this.seller = seller;
	}
	public ArrayList<Offer> getOffers() {
		return offers;
	}
	public void setOffers(ArrayList<Offer> offers) {
		this.offers = offers;
	}
	
	public ProductStatus getStatus() {
		return status;
	}
	public void setStatus(ProductStatus status) {
		this.status=status;
	}
	public void setProductDetails(ProductDetails details) {
		this.details=details;
	}
	public ProductDetails getProductDetails() {
		return details;
	}

	
	public void addOffer(Offer offer) {
		offers.add(offer);
		ProductDB.updateOffers(this);
	}
	
	public boolean isValidBuyer(Student student) {
		if(student.getNetid() == this.seller.netId){
			return true;
		}
		return false;
	}
	
	public boolean checkAvailability(){
		if(this.getStatus().equals("Available")){
			return true;
		}
		return false;
	}
}
