package com.cometsale.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cometsale.model.Product;
import com.cometsale.model.Student;
import com.cometsale.model.SupplierHelper;
import com.cometsale.mongodb.ProductDB;
import com.cometsale.mongodb.UserDB;

@Controller
public class SellerController {

	@RequestMapping(value = "/viewOffers/{productId}" ,method = RequestMethod.GET)
	public String viewOffers(HttpSession session,HttpServletRequest request, ModelMap model, @PathVariable String productId) {
		
		session.setAttribute("sellpid", productId);
		return "viewOffers";
	}
	
	@RequestMapping(value = "/lockProduct/{productId}/{buyerId}" ,method = RequestMethod.GET)
	public String lockProduct(HttpSession session,HttpServletRequest request, ModelMap model, @PathVariable String productId,@PathVariable String buyerId) {
		Product product= ProductDB.find(productId, "productId").get(0);
		
		String netID = session.getAttribute("NetID").toString();
        ArrayList<Student> findResult= UserDB.find(netID,"netid");

        ArrayList<Student> findResult2= UserDB.find(buyerId,"netid");
        
		Student seller = findResult.get(0);	
		Student buyer = findResult2.get(0);
				
	
		System.out.println("Lock ProductID: "+product.getProductId());
		System.out.println("Lock buyerID: "+buyer.getNetid());
		
		
		SupplierHelper.lockProduct(seller,buyer,product);
		

		return "successfullocked";
	}
}
