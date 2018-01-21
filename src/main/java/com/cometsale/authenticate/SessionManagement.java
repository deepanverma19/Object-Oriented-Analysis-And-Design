package com.cometsale.authenticate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cometsale.beans.LoginBean;
import com.cometsale.model.StudentDetails;

public class SessionManagement {
	public static final String SessionNetID = "NetID";
	public static final String SessionFirstName = "FirstName";
	public static final String Lastlogin = "6:20PM";
	
	public static void createSessionUser(HttpServletRequest request, LoginBean bean){
	HttpSession session = request.getSession();
	session.setAttribute(SessionNetID, bean.getNetID());
	session.setAttribute(SessionFirstName, 0);
	
	}
	public static void createSessionLastlogin(HttpServletRequest request, StudentDetails ud) throws ParseException{
		HttpSession session = request.getSession();
		
	}
	
	public static int validSessionUser(HttpSession session){
		if(session.getAttribute(SessionNetID)!=null || session.getAttribute(SessionNetID)!=""){
			return 1;
		}else{
			return 0;
		}
	}
	public void logoutSessionUser(HttpSession session){
		session.invalidate();
	}
}