package com.mongo.assign;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PreviousTaskQuery {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			MongoDatabase db = mongo.getDatabase("mongoAssign01");
			
			System.out.println("Connected to Database "+db);
			
			MongoCollection<Document> companyCollection =  db.getCollection("company");
			MongoCollection<Document> empCollection =  db.getCollection("employee");
			
			//Count no of companies
			long numberOfCompany=companyCollection.count();
			System.out.println("number of companies : "+numberOfCompany);
			
			//Count no of Employees
			long numberOfEmployee=empCollection.count();
			System.out.println("number of employees : "+numberOfEmployee);
			
			
			
			//find companies which are less than 10 years
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("since", new BasicDBObject("$lt", 10));

			FindIterable<Document> iterDoc = companyCollection.find(whereQuery);
			
			int i = 1;
			// Getting the iterator
			Iterator it = iterDoc.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				i++;
			}
			
			System.out.println("collection created successfully");
			
		}catch(Exception e) {
			System.out.println(e);
		} 

	}

}
