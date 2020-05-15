package com.mongo.assign;

import java.util.Arrays;
import java.util.List;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DisplayEmployeeKumar {

	public static void main(String[] args) {


		try {
			
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			DB db = mongo.getDB("mongoAssign01");
			
			DBCollection empCollection = db.getCollection("employee");
			
			// create the pipeline operations, first with the $match
	        DBObject match = new BasicDBObject("$match",
	            new BasicDBObject("name", "Kapil")
	        );
	        
	        // build the $lookup operations
	        DBObject lookupFields = new BasicDBObject("from", "company");
	        lookupFields.put("localField", "company");
	        lookupFields.put("foreignField", "_id");
	        lookupFields.put("as", "EmployeeData");      
	        DBObject lookup = new BasicDBObject("$lookup", lookupFields);
	        
	        
	        // build the $project operations
	        DBObject projectFields = new BasicDBObject("name", 1);
	        projectFields.put("experience", 1);
	        projectFields.put("_id", 0);
	        projectFields.put("email", 1);       
	        DBObject project = new BasicDBObject("$project", projectFields);
	        
	        
	        List<DBObject> pipeline = Arrays.asList(match, lookup, project);

	        AggregationOutput output = empCollection.aggregate(pipeline);
	        
	        for (DBObject result : output.results()) {
	            System.out.println(result);
	        }
			
			System.out.println("Successfully Done");
			
		}catch(Exception e) {
			System.out.println(e);
		} 

	}

}
