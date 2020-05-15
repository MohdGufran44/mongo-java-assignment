package com.mongo.assign;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Company {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			MongoDatabase db = mongo.getDatabase("mongoAssign01");
			
			MongoCollection<Document> collection =  db.getCollection("company");
			Document document = new Document("name", "SB").append("since", "26");
			Document document1 = new Document("name", "Pieriandx").append("since", "6");
			Document document2 = new Document("name", "Persistent").append("since", "14");
			
			List<Document> documents = new ArrayList<>();
			documents.add(document);
			documents.add(document1);
			documents.add(document2);
			
			collection.insertMany(documents);
			
			System.out.println("collection created successfully");
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		} 

	}

}
