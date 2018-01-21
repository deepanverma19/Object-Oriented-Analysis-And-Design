package com.cometsale.mongodb;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.cometsale.model.StudentDetails;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;



public class OldUserDb {
    
    public static void push(StudentDetails inputUser){
        //get a client and database
        MongoClient mongoClient =initConnection();
        MongoDatabase database = connectDatabase(mongoClient);
        
        //push the object
        MongoCollection<StudentDetails> collection = database.getCollection("user",StudentDetails.class);
        System.out.println(""+collection);
        collection.insertOne(inputUser);
        
        //close the connection.
        closeConnection(mongoClient);
    }
    
    public static void closeConnection(MongoClient mongo){
        mongo.close();
    }
    
    
    public static MongoDatabase connectDatabase(MongoClient mongoClient){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoDatabase database = mongoClient.getDatabase("cometsale").withCodecRegistry(pojoCodecRegistry);
        return database;
    }
//    public static void push(Class className, Object object){
//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//        
//        MongoClientURI connectionString = new MongoClientURI("mongodb://Team5:UTDteam5@ds139124.mlab.com:39124/cometsale");
//        MongoClient mongo = new MongoClient(connectionString);
//        MongoDatabase database = mongo.getDatabase("cometsale").withCodecRegistry(pojoCodecRegistry);
//        
//        MongoCollection<UserDetails> collection = database.getCollection("user",className);
//      
//        collection.insertOne((className)object);
//        mongo.close();
//    }

    private static MongoClient initConnection() {
       
        MongoClientURI connectionString = new MongoClientURI("mongodb://Team5:UTDteam5@ds139124.mlab.com:39124/cometsale");
        MongoClient mongoClient = new MongoClient(connectionString);
        return mongoClient;
        
    }
}   
