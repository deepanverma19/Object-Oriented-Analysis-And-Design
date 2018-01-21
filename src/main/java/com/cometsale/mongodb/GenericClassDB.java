package com.cometsale.mongodb;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;


import java.util.ArrayList;


public  class GenericClassDB {
    
    public static MongoClient initConnection() {
        
        MongoClientURI connectionString = new MongoClientURI("mongodb://Team5:UTDteam5@ds139124.mlab.com:39124/cometsale");
        MongoClient mongoClient = new MongoClient(connectionString);
        return mongoClient;
        
    }

    public static MongoDatabase connectDatabase(MongoClient mongoClient){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoDatabase database = mongoClient.getDatabase("cometsale").withCodecRegistry(pojoCodecRegistry);
        return database;
    }
    
    public static void closeConnection(MongoClient mongo){
        mongo.close();
    }
    
    public static <T> void push(T inputObject){
        //get a client and database
        MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //get the collectionName
        Class className=inputObject.getClass();
        String classNameString= className.toString();
        String collectionName =classNameString.substring(classNameString.lastIndexOf('.') + 1);
        
        //connect to collection
        MongoCollection<T> collection = database.getCollection(collectionName,className);
        
        //push to collection
        collection.insertOne(inputObject);
        
        //close the connection.
        closeConnection(mongoClient);
    }
    
    public static <T> Object find(Class inputModel,String searchString, String searchAttribute) {
        //get a client and database
        MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //get the collectionName
        String classNameString= inputModel.toString();
        String collectionName =classNameString.substring(classNameString.lastIndexOf('.') + 1);
        
        //connect to collection
        MongoCollection<T> collection = database.getCollection(collectionName,inputModel);
        
        //find document
        ArrayList<T> output =  collection.find(eq(searchAttribute, searchString)).into(new ArrayList());
        
        //close the connection.
        closeConnection(mongoClient);
        
        return output;
    }
    
    public static <T> void update(Class inputModel,String searchString, String searchAttribute,String updateString,String updateAttribute) {
        //get a client and database
        MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //get the collectionName
        String classNameString= inputModel.toString();
        String collectionName =classNameString.substring(classNameString.lastIndexOf('.') + 1);
        
        //connect to collection
        MongoCollection<T> collection = database.getCollection(collectionName,inputModel);
        
        //update document
        collection.updateOne(eq(searchAttribute, searchString), combine(set(updateAttribute, updateString)));
        
        //close the connection.
        closeConnection(mongoClient);
        
        return;
    }
    
}
