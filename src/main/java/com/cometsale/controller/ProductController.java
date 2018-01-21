package com.cometsale.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cometsale.model.Address;
import com.cometsale.model.Product;
import com.cometsale.model.Student;
import com.cometsale.model.ProductDetails;
import com.cometsale.mongodb.GenericClassDB;
import com.cometsale.mongodb.ProductDB;
import com.cometsale.uimodel.ProductResponseModel;
import com.cometsale.mongodb.UserDB;
import com.cometsale.model.StudentDetails;

@Controller
public class ProductController {

	@RequestMapping(value = "/addProduct" ,method = RequestMethod.GET)
	public String addProduct(ModelMap model) {
		System.out.println("entered add product page");
		return "newauction";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, ModelMap model){
		System.out.println("Searching the product entered");
		ProductDB product = new ProductDB();
		ArrayList<Product> records = product.search(request.getParameter("searched"));
		return "searchedpage";
	}
	
	@RequestMapping(value = "/successfulAddedProduct", method = RequestMethod.POST)
	public String register(HttpSession session,HttpServletRequest request,ModelMap model, @RequestParam("image") MultipartFile file)  {
		
		System.out.println("Added Product");
		Product newProduct = new Product();
		
		String netID = session.getAttribute("NetID").toString();
        ArrayList<Student> findResult= UserDB.find(netID,"netid");
		
		Student seller = findResult.get(0);
		
		//default response
		
		ProductResponseModel userModel = new ProductResponseModel();
		userModel.setDefaultValue();
		newProduct.setSeller(seller);
		newProduct.getProductDetails().setProductName(request.getParameter("productName"));
		newProduct.getProductDetails().setCategory(request.getParameter("category"));
		newProduct.getProductDetails().setOfferPrice(Double.parseDouble(request.getParameter("offerPrice")));
		newProduct.getProductDetails().setQuality(request.getParameter("quality"));
		newProduct.getProductDetails().setProductDesc(request.getParameter("productDescription"));
		if(!file.isEmpty()) {
			
			byte[] bytes;
			try {
				bytes = file.getBytes();
				newProduct.getProductDetails().setImageBytes(bytes);
				System.out.println("size"+Integer.toString(bytes.length)+"uploaded size:"+Integer.toString(newProduct.getProductDetails().getImageBytes().length));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		}
		
		Address houseAddress = new Address();
		houseAddress.setCity(request.getParameter("city"));
		houseAddress.setPinCode(request.getParameter("pinCode"));
		houseAddress.setState(request.getParameter("state"));
		houseAddress.setStreetname(request.getParameter("streetName"));
		houseAddress.setAptNo(request.getParameter("AptNo"));
		newProduct.getProductDetails().setPickupAddress(houseAddress);

		System.out.println(newProduct.getProductId());
		System.out.println(newProduct.getProductDetails().getProductDesc());
		System.out.println(newProduct.getProductDetails().getPickupAddress().getCity());
		   

		if(newProduct.getProductDetails().getProductDesc() == null || 
				newProduct.getProductDetails().getProductName() == null || 
		//   newUser.getUserName() == null ||
		 //  newUser.getPassword() == null ||
		   newProduct.getProductDetails().getOfferPrice() == 0.0 || 
		   newProduct.getProductDetails().getCategory() == null || 
		   newProduct.getProductDetails().getPickupAddress().getCity() == null || 
		   newProduct.getProductDetails().getPickupAddress().getPinCode() == null || 
		   newProduct.getProductDetails().getPickupAddress().getState() == null || 
		   newProduct.getProductDetails().getPickupAddress().getStreetname() == null){
		   model.addAttribute("ERR_MSG", "Enter all fields correctly");
		   return "registration_error";
		}
		
		// call database if successful, then return Positive response.
		// TODO: Rename GenericClassDB to some database Name.
		// TODO: GenericClassDB should give proper error if there is a problem.
		// TODO: To have specific function we need to have Db classes for each Model.
		// TODO: All Db class send some exceptions.
		
		//check if the resgistration number is already present.
		ArrayList<Product> resultList = ProductDB.find(newProduct.getProductId(),"productID");
		
		if(!(resultList.isEmpty())) {
			 userModel.setErrorMessage("Product Already Exists");
				model.addAttribute("ERR_MSG", "Product Already Exists");
			return "registration_error";
		}
		
		System.out.println(newProduct);
		
		try {
			GenericClassDB.push(newProduct);
		}
		catch(Exception e) {
			userModel.setErrorMessage(e.getMessage());
			model.addAttribute("ERR_MSG", "Database Failed to register product");
		return "registration_error";
		}
		 
		return "successfulproductadded";
	}


	@RequestMapping(value = "/removeFromWishlist" ,method = RequestMethod.GET)
	public String removeFromWishlist(ModelMap model) {
		System.out.println("Successfully removed from wishlist");
		return "removefromwishlist";
	}
	
	
	@RequestMapping(value = "/addToWishlist/{productId}" ,method = RequestMethod.GET)
	public String addToWishlist(HttpSession session,HttpServletRequest request, ModelMap model, @PathVariable String productId) {
		
		Product dumyProduct= new Product();
		dumyProduct.setProductId(productId);
		
		String netID = session.getAttribute("NetID").toString();
        ArrayList<Student> findResult= UserDB.find(netID,"netid");
		System.out.println("NetID: "+netID);
		Student s = findResult.get(0);
		
		s.addProductToWishlist(dumyProduct);
		
		return "successfuladdedtowishlist";
	}
	
	@RequestMapping(value = "/removeFromWishlist/{productId}" ,method = RequestMethod.GET)
	public String removeFromWishlist(HttpSession session,HttpServletRequest request, ModelMap model, @PathVariable String productId) {
		
		Product dumyProduct= new Product();
		dumyProduct.setProductId(productId);
		System.out.println("remove from wishlist"+dumyProduct.getProductId());
		
		String netID = session.getAttribute("NetID").toString();
        ArrayList<Student> findResult= UserDB.find(netID,"netid");
		
		Student s = findResult.get(0);
		
		s.removeProductFromWishlist(dumyProduct);

		return "removedFromWishlist";
	}
	
	@RequestMapping(value = "/makeAnOffer/{productId}" ,method = RequestMethod.GET)
	public String makeAnOffer(HttpSession session,HttpServletRequest request, ModelMap model, @PathVariable String productId) {
		
		Product product= ProductDB.find(productId, "productId").get(0);
		
		String netID = session.getAttribute("NetID").toString();
        ArrayList<Student> findResult= UserDB.find(netID,"netid");
		
		Student s = findResult.get(0);
		
		s.getWishList().makeAnOffer(product, s);
		

		return "successfulMakeOffer";
	}
	
	@RequestMapping(value = "/sellerProducts", method = RequestMethod.GET)
	public String sellerProducts(ModelMap model){
		System.out.println("Seller Products");
		return "sellerproducts";
	}
	
}
