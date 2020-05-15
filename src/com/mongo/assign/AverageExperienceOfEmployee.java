package com.mongo.assign;

import java.util.Arrays;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;

public class AverageExperienceOfEmployee {

	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			MongoDatabase db = mongo.getDatabase("mongoAssign01");
			
			MongoCollection<Document> empCollection =  db.getCollection("employee");
			
			AggregateIterable<Document> documents
	        = empCollection.aggregate(Arrays.asList(Aggregates.group("$company",
	                                Accumulators.avg("averageExperience", "$experience"))));
			
			
			// Getting the iterator
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
