package com.cometsale.model;

import java.util.ArrayList;

import com.cometsale.mongodb.ProductDB;

public class SupplierHelper {
	
	
	public void postProduct(){
		
	}
	
	public void closeProduct(Student seller,Product p) {
		if(p.getSeller().getNetid().equals(seller.getNetid())) {
			p.setStatus(ProductStatus.closed);
			ProductDB.closeProduct(p);
		}
	}

	public static void lockProduct(Student seller,Student buyer,Product p) {
		if(p.getSeller().getNetid().equals(seller.getNetid())) {
			p.setStatus(ProductStatus.locked);
			ProductDB.lockProduct(p);
			
			ArrayList<Offer> offers=p.getOffers();
			for(Offer offer : offers) {
				if(offer.getBuyer().getNetid().equals(buyer.getNetid())) {
					offer.lockOffer();
					ProductDB.updateOffers(p);
				}
				
			}
			
		}
	}

	
	public static ArrayList<Student> fetchOfferedBuyer(Student seller,Product p){
		
		if(p.getSeller().getNetid().equals(seller.getNetid())) {
			ArrayList<Student> output= new ArrayList<Student>();
			ArrayList<Offer> offers=p.getOffers();
			for(Offer offer : offers) {
				output.add(offer.getBuyer());
				
			}
			return output;
			}
		else {
			return null;
		}
	}
}
