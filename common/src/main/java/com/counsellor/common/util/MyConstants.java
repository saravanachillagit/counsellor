package com.counsellor.common.util;

public class MyConstants {

	
	// THIS BLOCK SHOULD BE LEFT IS FOR ALL THE ENVIRONMENTS. NO
	// NEED TO CHANGE ANY THING.
	//public static final String CASSANDRA_HOST = "localhost:9160";// 
	//public static final String SOLR_HOST = "http://localhost:8983/solr/"; 
	public static final String MYSQL_HOST = "jdbc:mysql://localhost:3306/yycstage_test1"; 

	
	/* PLEASE DO NOT USE ANY OF THESE SETTINGS. 
	 * THESE WILL BE REMOVED PRETTY SOON. 
	 */
	// Enable this block for OLD Staging
	public static final String CASSANDRA_HOST = "162.144.36.152:9160"; 
	public static final String SOLR_HOST = "http://162.144.36.152:8983/solr/";  

	// Enable this block for NEW Staging
	//public static final String CASSANDRA_HOST = "192.163.242.131:9160"; 
	//public static final String SOLR_HOST = "http://192.163.242.131:8983/solr/";  

	
	// Enable this block for Production. Please correct the values..
	//public static final String CASSANDRA_HOST = "162.144.89.206:9160"; 
	//public static final String SOLR_HOST = "http://162.144.89.206:8983/solr/"; 
}
