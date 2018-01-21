package com.cometsale.modelController;

import com.cometsale.mongodb.GenericClassDB;

public class GenericController {
	private GenericClassDB DbMgr;
	
	public GenericController(){
		
	}
	
	//singleton
	 public GenericClassDB  getDBMgrInstance(){
		 if(DbMgr == null){
			 DbMgr= new GenericClassDB();
		 }
		 return DbMgr;
	 }
	
}
