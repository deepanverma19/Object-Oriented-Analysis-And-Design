/*
 * Copyright 2017 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cometsale.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.security.util.FieldUtils;

import com.cometsale.model.Address;
import com.cometsale.model.BuyerHelper;
import com.cometsale.model.Offer;
import com.cometsale.model.Product;
import com.cometsale.model.StudentDetails;
import com.cometsale.model.SupplierHelper;
import com.cometsale.model.WishList;
import com.cometsale.mongodb.UserDB;
import com.cometsale.uimodel.UserResponseModel;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.cometsale.model.ProductDetails;
import com.cometsale.model.ProductStatus;
import com.cometsale.model.Student;
import com.cometsale.mongodb.GenericClassDB;
import com.cometsale.mongodb.ProductDB;
import com.cometsale.mongodb.SchemaBuilder;


public class test {
  
    public static void main(final String[] args) {
       
/*	UserDetails newUser = new UserDetails();
		
		newUser.setNetID("20237865");
		//newUser.setUserName(request.getParameter("username"));
		newUser.setFirstName("Akhilesh");
		newUser.setLastName("Kumar");
		//TODO:password.
		newUser.setEmail("akhi.x319@gmail.com");
		newUser.setPhoneNumber("4696644745");
		
		Address houseAddress = new Address();
		houseAddress.setCity("Dallas");
		houseAddress.setPinCode("75252");
		houseAddress.setState("Richardson");
		houseAddress.setStreetname("7815 McCallum");
		houseAddress.setAptNo("16101");
		newUser.setHomeAddress(houseAddress);
		
		UserDB.push(newUser);
		
		
		UserDetails newUser2 = new UserDetails();
		
		
		newUser2.setNetID("202378651");
		//newUser.setUserName(request.getParameter("username"));
		newUser2.setFirstName("Akhilesh1");
		newUser2.setLastName("Kumar");
		//TODO:password.
		newUser2.setEmail("akhi.x319@gmail.com");
		newUser2.setPhoneNumber("4696644745");
		
		Address houseAddress2 = new Address();
		houseAddress2.setCity("Dallas");
		houseAddress2.setPinCode("75252");
		houseAddress2.setState("Richardson");
		houseAddress2.setStreetname("7815 McCallum");
		houseAddress2.setAptNo("16101");
		newUser2.setHomeAddress(houseAddress2);
		System.out.println(newUser2);
		
		UserDB.push(newUser2);
		
   
	  UserDetails findResult= UserDB.find("Akhilesh1","firstName").get(0);
	  System.out.println("firstName:"+findResult.getFirstName()+"\nNetID:"+findResult.getNetID());
	    
	  UserDB.update("202378651","netID","updateFirstName", "firstName");
	  
	  findResult=(UserDetails) UserDB.find("202378651","netID").get(0);
	  System.out.println("firstName:"+findResult.getFirstName()+"\nNetID:"+findResult.getNetID());*/
      
//      ProductDetails testProduct=new ProductDetails();
//      System.out.println("Product:"+testProduct.getProductID());
//      
//      File path = new File("C:\\Users\\Jiawku\\Pictures\\test.jpg");
//      testProduct.setProductName("test");
//      FileInputStream imageInFile;
//	try {
//	imageInFile = new FileInputStream(path);
//      byte[] imageData = new byte[(int) path.length()];
//		imageInFile.read(imageData);
//		imageInFile.close();
//		System.out.print(Integer.toString(imageData.length));
//      testProduct.setImageBytes(imageData);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//    ProductDB.push(testProduct);
//      
//	ProductDetails findResult= ProductDB.find("test","productName").get(0);
//    System.out.println("Product:"+findResult.getProductID());
//    System.out.print(Integer.toString(findResult.getImageBytes().length));
//    FileOutputStream fos;
//	try {
//		fos = new FileOutputStream("C:\\\\Users\\\\Jiawku\\\\Desktop\\\\testout.jpg");
//		fos.write(findResult.getImageBytes());
//		fos.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}


//    ArrayList<Product> returnList=ProductDB.fetchAllOpen();
//    
////    returnList.get(0).setStatus(ProductStatus.locked);
//    for(Product i:returnList) {
//    	System.out.println(i.toString());
//    }
    	

//    Student user=UserDB.find("testuser","netid").get(0);
//    Product product=ProductDB.find("0d769b03-f668-4db2-8df8-5f7fcd2914bb","productId").get(0);
////
////    user.getWishList().addProductToWishlist(product);
////    System.out.println(user.getWishList().getWishList()3.get(0).getProductDetails().toString());
//   
//    Student seller=UserDB.find("testuser","netid").get(0);
//    
//    product.setSeller(seller);
//    
////    product.setOffers(new ArrayList<Offer>());
//    
      Student buyer=UserDB.find("testuser", "netid").get(0);
//    
      Student seller=UserDB.find("seller", "netid").get(0);
      
      Product product=ProductDB.find("197555a4-3680-4dcc-bfb1-6565749ba26b","productId").get(0);
//    buyer.getWishList().makeAnOffer(product, buyer);
//    
////    ProductDB.updateOffers(product);
//    
//    System.out.println(product.getOffers().get(0).getBuyer().toString());
    
    
    
//    user.addProductToWishlist(product);
//    
//      UserDB.updateWishList(user);
//    System.out.println(user.fetchWishListArray().toString());
//    System.out.println(BuyerHelper.fetchBuyerWishList(user).size());
//    System.out.println(BuyerHelper.fetchBuyerWishList(user).get(0).getProductDetails().toString());
//    System.out.println(BuyerHelper.fetchBuyerWishList(user).get(1).getProductDetails().toString());
//    
//
//    
    
     SupplierHelper.lockProduct(seller,buyer,product);
    
    }
}