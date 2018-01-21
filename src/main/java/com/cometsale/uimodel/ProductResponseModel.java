package com.cometsale.uimodel;

public class ProductResponseModel extends ResponseModel {
	
	int productId ; 
	String productName ;
	
	public ProductResponseModel() {
		super();
		
		
	}
	public void setDefaultValue() {
		super.setDefaultValue();
		// Default.
		this.productId =0;
		this.productName = "";		 
	}
	public int getProductId() {
		return productId;
	}
	public void getProductId(int productId) {
		this.productId = productId;
	}
	public String getUsername() {
		return productName;
	}
	public void setUsername(String productName) {
		this.productName = productName;
	}
		
	
}