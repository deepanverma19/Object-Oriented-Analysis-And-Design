package com.cometsale.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cometsale.authenticate.SessionManagement;
import com.cometsale.beans.LoginBean;
import com.cometsale.model.Address;
import com.cometsale.model.Student;
import com.cometsale.model.Product;
import com.cometsale.model.WishList;
import com.cometsale.mongodb.GenericClassDB;
import com.cometsale.mongodb.UserDB;
import com.cometsale.uimodel.UserResponseModel;

@Controller
public class UserController {
	
	@RequestMapping(value = {"/viewProfile"}, method = RequestMethod.GET)
	 	public String viewProfile(HttpServletRequest request,ModelMap model){
			String netID = (String) request.getSession().getAttribute(SessionManagement.SessionNetID);
			
			//check if the Netid exists in database.
			ArrayList<Student> findResult= UserDB.find(netID,"netid");
			if(findResult==null){
				//TODO: handle user not found.
				System.out.println("User Not found!");
				return "userinfo";
			}
			Student user = findResult.get(0);
			model.addAttribute("user",user);
			model.addAttribute("userDetails",user.details);
			System.out.println(user.getNetid());
			
	 		return "userinfo";
	 	}
	
	@RequestMapping(value = "/addUser" ,method = RequestMethod.GET)
	public String addNewUser(ModelMap model) {
		System.out.println("entered add user page");
		return "registration";
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("entered normal");
		return "registration";
	}
	
	@RequestMapping(value = "/successfulLogin", method = RequestMethod.POST)
	public String successfulLogin(HttpServletRequest request,ModelMap model) {
		LoginBean bean = new LoginBean();
		bean.setNetID(request.getParameter("name"));
		bean.setPassword(request.getParameter("password"));
		//TODO: password Authenication.
		request.setAttribute("bean", bean);
		System.out.println(bean.getNetID());
		System.out.println(bean.getPassword());
		SessionManagement.createSessionUser(request, bean);	
		return "homepage";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model){
		return "logout";
	}
	
	@RequestMapping(value ="/viewWishlist", method = RequestMethod.GET)
 	public String directToWishList(HttpServletRequest request,ModelMap model){
		return "viewwishlist";
  	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,ModelMap model) {
		return "loginpage";
	}
	
	@RequestMapping(value ="/homepage", method = RequestMethod.GET)
	 	public String directToHomepage(HttpServletRequest request,ModelMap model){
	 		return "homepage";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,ModelMap model) {
		
		System.out.println("entered Register");
		Student newUser = new Student();
		
		//default response
		
		UserResponseModel userModel = new UserResponseModel();
		userModel.setDefaultValue();

		newUser.setNetid(request.getParameter("netID"));
		//newUser.setUserName(request.getParameter("username"));
		newUser.details.setFirstName(request.getParameter("firs tName"));
		newUser.details.setLastName(request.getParameter("lastName"));
		//TODO:password.
		newUser.details.setEmail(request.getParameter("email"));
		newUser.details.setPhoneNumber(request.getParameter("phoneNumber"));
		
		Address houseAddress = new Address();
		houseAddress.setCity(request.getParameter("city"));
		houseAddress.setPinCode(request.getParameter("pinCode"));
		houseAddress.setState(request.getParameter("state"));
		houseAddress.setStreetname(request.getParameter("streetName"));
		houseAddress.setAptNo(request.getParameter("AptNo"));
		newUser.details.setHomeAddress(houseAddress);


		if(newUser.getNetid() == null || 
		   newUser.details.getLastName() == null || 
		//   newUser.getUserName() == null ||
		 //  newUser.getPassword() == null ||
		   newUser.details.getEmail() == null || 
		   newUser.details.getPhoneNumber() == null || 
		   newUser.details.getHomeAddress().getCity() == null || 
		   newUser.details.getHomeAddress().getPinCode() == null || 
		   newUser.details.getHomeAddress().getState() == null || 
		   newUser.details.getHomeAddress().getStreetname() == null){
		   model.addAttribute("ERR_MSG", "Enter all fields correctly");
		   return "registration_error";
		}
		
		// call database if successful, then return Positive response.
		// TODO: Rename GenericClassDB to some database Name.
		// TODO: GenericClassDB should give proper error if there is a problem.
		// TODO: To have specific function we need to have Db classes for each Model.
		// TODO: All Db class send some exceptions.
		
		//check if the resgistration number is already present.
		ArrayList<Student> resultList = UserDB.find(newUser.getNetid(),"netID");
		Student findResult;
		
		if(!(resultList.isEmpty())) {
			 findResult= UserDB.find(newUser.getNetid(),"netID").get(0);
			 userModel.setErrorMessage("User Already Exists");
				model.addAttribute("ERR_MSG", "UserAlready Exists");
			return "registration_error";
		}
		
			
		System.out.println(newUser);
		
		try {
			GenericClassDB.push(newUser);
		}
		catch(Exception e) {
			userModel.setErrorMessage(e.getMessage());
			model.addAttribute("ERR_MSG", "Database Failed to register user");
		return "registration_error";
		}
		 
		return "successfulregister";
	}

}
