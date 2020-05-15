package com.mongo.assign;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

public class RegexSearchForEmployeeEmail {

	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			MongoDatabase db = mongo.getDatabase("mongoAssign01");
			
			MongoCollection<Document> empCollection =  db.getCollection("employee");
			
			Document regQuery = new Document();
			regQuery.append("$regex", "um");
			
			Document findQuery = new Document();
			findQuery.append("email", regQuery);
			
			FindIterable<Document> documents = empCollection.find(findQuery)
					.sort(Sorts.ascending("experience"));
			
			
			Iterator it = documents.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			
			System.out.println("successfully Done!");
			
		}catch(Exception e) {
			System.out.println(e);
		} 

	}

}
