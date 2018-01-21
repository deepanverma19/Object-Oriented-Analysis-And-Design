package com.cometsale.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cometsale.model.Product;
import com.cometsale.model.ProductDetails;
import com.cometsale.mongodb.ProductDB;

@Controller
public class ImageController {

/*	@RequestMapping(value = "/imageController/{imageId}")
	@ResponseBody
	public byte[] helloWorld(@PathVariable long imageId)  {
		ProductDetails findResult=(ProductDetails) ProductDB.find("8888","productID").get(0);
		byte[] imageData=findResult.getImageBytes();
		return imageData;

	}
	*/
	
	 @RequestMapping(value = "/imageController/{id}", method = RequestMethod.GET)
	 public void showImage(@PathVariable String id,HttpServletResponse response,HttpServletRequest request) throws IOException {

		Product findResult=(Product) ProductDB.find(id,"productId").get(0); 
		byte[] imageData=findResult.getProductDetails().getImageBytes();
		
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    OutputStream stream = response.getOutputStream();
	    stream.write(imageData);     
        stream.flush();
        stream.close();
        
	 }	
}