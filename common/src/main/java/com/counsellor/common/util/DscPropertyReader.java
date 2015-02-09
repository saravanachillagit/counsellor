package com.counsellor.common.util;

/**
 * Singleton class to read properties from property file
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DscPropertyReader {

	  private static final Logger s_logger = MyLogger.getLogger(DscPropertyReader.class);

	private static DscPropertyReader reader = null;
	private Properties configProp = new Properties();

	public static DscPropertyReader getInstance() {
		if (reader == null) {
			reader = new DscPropertyReader();
			reader.loadProperties();
		}
		return reader;
	}

	// Loads the properties file
	private void loadProperties() {
		try {
			InputStream dsc = DscPropertyReader.class.getResourceAsStream("/dsc.properties");
			if(dsc == null) {
				if (s_logger.isDebugEnabled())
						s_logger.debug("ERROR: Unable to read dsc.properties");
			}else{
				configProp.load(dsc);
			}
		} catch (IOException e) {
		}
	}

	// Gets the value of the property
	public String getPropertyValue(String propertyName) {
		if(configProp.containsKey(propertyName)){
			return configProp.getProperty(propertyName);
		}
		return null;
	}
	
	public static void main(String args[]){
		DscPropertyReader.getInstance().loadProperties();
	}
}
