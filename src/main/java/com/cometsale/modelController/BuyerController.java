package com.cometsale.modelController;

import java.util.List;

import com.cometsale.model.Product;
import com.cometsale.model.Student;
import com.cometsale.model.WishList;
import com.cometsale.mongodb.GenericClassDB;
import com.cometsale.mongodb.ProductDB;

public class BuyerController extends GenericController {
	
	
	public List<Product> searchProduct(String category, String value){

		ProductDB db = new ProductDB();
		List<Product>  Products = db.find(category, value);
		return Products;
	}
	// this method is not needed anymore, since we made the  table in javascript.
	public String displaySearchResults() {
			return null;
		}
	
	public boolean addProductToWishList(int studentid, int productid) {
		GenericClassDB dbmgr = this.getDBMgrInstance();
		
		Student student = (Student) dbmgr.find(Student.class,String.valueOf(studentid), "");
		Product product = (Product) dbmgr.find(Product.class,String.valueOf(productid), "");
		if(student!=null && product!=null){
			if(product.isValidBuyer(student)){
				if(product.checkAvailability()){
					WishList wishList = student.getWishList();
					wishList.addProduct(product);	
				}
			}
		}
		
		return true;
	}
	
	public boolean accept(int buyerid,int sellerid,int productid) {
		return true;
	}
	
	public boolean reject(int buyerid,int sellerid,int productid) {
		return true;
	}
	
	public void makeAnOffer(int productid, int buyerid) {
		return ;
	}

}
