package com.cometsale.mongodb;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.bson.Document;

import com.cometsale.model.Offer;
import com.cometsale.model.Product;
import com.cometsale.model.Student;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class ProductDB extends GenericClassDB {

    public static void push(Product inputProduct) {
        GenericClassDB.push(inputProduct);
    }


    public static ArrayList<Product> find(String searchString, String searchAttribute) {
        return (ArrayList<Product>) GenericClassDB.find(Product.class,searchString,searchAttribute);
    }
    
    public static Product getFromPid(String pid) {
    	if (productIDinDB(pid)) {
    		ArrayList<Product> fetchResult=(ArrayList<Product>) GenericClassDB.find(Product.class,pid,"productId");
    		return fetchResult.get(0);
    	} else {
    		return null; 
    	}
    }
    
    public static ArrayList<Product> search(String query) {
    	
   	    
	    MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
//        ArrayList<Product> output = collection.find(Filters.text(query))
//        									.projection(Projections.metaTextScore("score"))
//        									.sort(Sorts.metaTextScore("score")).into(new ArrayList());
                
        Document regQuery = new Document();
        regQuery.append("$regex", Pattern.quote(query));
        regQuery.append("$options", "i");

        Document findQuery1 =  new Document(),findQuery2 = new Document();
        findQuery1.append("productDetails.productName", regQuery);
        findQuery2.append("productDetails.productDesc", regQuery);

        BasicDBList or = new BasicDBList();
        or.add(findQuery1);
        or.add(findQuery2);
        BasicDBObject inquery = new BasicDBObject("$or", or);
        ArrayList<Product> output = collection.find(inquery).into(new ArrayList());
        
        closeConnection(mongoClient);
        return output;
    
    }
    
    public static ArrayList<Product> fetchAll() {
    	return fetchAll(25);
    }
    
    public static ArrayList<Product> fetchAll(int limit) {
    	
   	    
	    MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
        
        ArrayList<Product> output =  collection.find().limit(limit).into(new ArrayList());
        int size = output.size();
        
        closeConnection(mongoClient);
        return output;
    
    }

    
    public static ArrayList<Product> fetchAllOpen() {
    	return fetchAllOpen(25);
    }
    
    public static ArrayList<Product> fetchAllOpen(int limit) {
    	
   	    
	    MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
        
        ArrayList<Product> output =  collection.find(eq("status", "open")).limit(limit).into(new ArrayList());
        int size = output.size();
        
        closeConnection(mongoClient);
        return output;
    
    }
    
    public static void update(String searchString, String searchAttribute,String updateString,String updateAttribute) {
        GenericClassDB.update(Product.class,searchString,searchAttribute,updateString,updateAttribute);
    }
    
    public static void updateOffers(Product p) {
    	 MongoClient mongoClient =initConnection();
         MongoDatabase database = connectDatabase(mongoClient);
         MongoCollection<Product> collection = database.getCollection("Product",Product.class);
         
         //update document
         collection.updateOne(eq("productId", p.getProductId()), combine(set("offers", p.getOffers())));
         
         //close the connection.
         closeConnection(mongoClient);
    }
    
    public static void lockProduct(Product p) {
   	 MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
        
        //update document
        collection.updateOne(eq("productId", p.getProductId()), combine(set("status", "locked")));
        
        //close the connection.
        closeConnection(mongoClient);
   }
   
    
    public static void closeProduct(Product p) {
      	 MongoClient mongoClient =initConnection();
           MongoDatabase database = connectDatabase(mongoClient);
           MongoCollection<Product> collection = database.getCollection("Product",Product.class);
           
           //update document
           collection.updateOne(eq("productId", p.getProductId()), combine(set("status", "closed")));
           
           //close the connection.
           closeConnection(mongoClient);
      }
      
    
    public static void uniqueConstraint() {
    	MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //push the object

        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
    	collection.createIndex(Indexes.ascending("productId"));
    	collection.createIndex(Indexes.text("productDesc"));
    	  //close the connection.
        closeConnection(mongoClient);	
    }
    
    public static boolean productIDinDB(String inputID) {
    	ArrayList<Product> result=find(inputID, "productId");
    	if(result.isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    public static ArrayList<Product> fetchFromIDArray(ArrayList<String> a){
		
    	MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        MongoCollection<Product> collection = database.getCollection("Product",Product.class);
    	
        
        BasicDBObject inQuery = new BasicDBObject();

        inQuery.put("productId", new BasicDBObject("$in", a));
        ArrayList<Product> result = collection.find(inQuery).into(new ArrayList());

    	return result;
    	
    }
}
