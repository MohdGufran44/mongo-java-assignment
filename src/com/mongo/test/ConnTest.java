package com.mongo.test;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ConnTest {

	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			DB db = mongo.getDB("mongoAssign01");
			System.out.println("Connected to Database "+db);
		}catch(Exception e) {
			System.out.println(e);
		} 
		
		System.out.println("Server is ready ");
		
		

	}

}
