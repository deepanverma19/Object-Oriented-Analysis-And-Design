package com.cometsale.mongodb;

public class SchemaBuilder {
	
	public static void main(String args[]) {
	    UserDB.uniqueConstraint();
	    ProductDB.uniqueConstraint();
	}

}
