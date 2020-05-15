package com.mongo.assign;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

public class employee {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			
			MongoDatabase db = mongo.getDatabase("mongoAssign01");
			
			System.out.println("Connected to Database "+db);
			
			ObjectId ids= new ObjectId("5ebd5a410dde2215dbf3c818");
			ObjectId ids1= new ObjectId("5e847cca1071eca67f791cbf");
			ObjectId ids2= new ObjectId("5e847cca1071eca67f791cc0");
			ObjectId ids3= new ObjectId("5e847cca1071eca67f791cc1");
			
			MongoCollection<Document> collection =  db.getCollection("employee");
			Document document = new Document("name", "kumar").append("email", "kumar@sb.com")
					.append("company", ids).append("experience", 4);
			
			Document document1 = new Document("name", "Anas").append("email", "anas@prx.com")
					.append("company", ids1).append("experience", 5);
			
			Document document2 = new Document("name", "kapil").append("email", "kapil@prst.com")
					.append("company", ids2).append("experience", 3);
			
			Document document3 = new Document("name", "lata").append("email", "lata@sb.com")
					.append("company", ids2).append("experience", 2);
			
			
			List<Document> documents = new ArrayList<>();
			documents.add(document);
			documents.add(document1);
			documents.add(document2);
			documents.add(document3);
			
			collection.insertMany(documents);
			
			collection.createIndex(Indexes.ascending("name"));
			
			System.out.println("collection created successfully");
			
		}catch(Exception e) {
			System.out.println(e);
		} 

	}

}
