package com.counsellor.common.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger extends Logger {

	public MyLogger(String name) {
		super(name);
	}

	static{
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	
}
