package com.cometsale.modelController;

import java.util.List;

import com.cometsale.model.Offer;
import com.cometsale.model.Product;

public class SellerController extends GenericController {
	
	public boolean postProduct(Product p) {
		return true;
	}
	
	public List<Offer> displayOffers(int productid){
		return  null;
	}
	
	public boolean lockOffer(int pid, int buyerid, int sellerid) {
		return true;
	}
 
	public boolean unlockOffer(int pid, int buyerid, int sellerid) {
		return false;
	}
}
