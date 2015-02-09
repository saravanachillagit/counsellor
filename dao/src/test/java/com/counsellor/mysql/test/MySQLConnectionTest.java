package com.counsellor.mysql.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

import com.counsellor.datasource.common.MySqlConnectionPool;

public class MySQLConnectionTest extends TestCase {

	//http://javaprogramming.language-tutorial.com/2012/09/a-sample-java-code-for-connection.html
    public void testConnect() {
	    String query = "Select distinct(table_name) from INFORMATION_SCHEMA.TABLES";
	    Connection connection = null;
	    try {
	        connection = MySqlConnectionPool.getInstance().checkout();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) {
		        String tableName = resultSet.getString(1);
		        System.out.println("Table name ...: " + tableName);
	        }
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally{
	    	MySqlConnectionPool.getInstance().checkin(connection);
	    }
    }
    
    public static void main(String[] args){
    	MySQLConnectionTest test = new MySQLConnectionTest();
    	test.testConnect();
    }
}
