package com.maintain.clean;

import java.io.*;
import java.util.*;

/****************************************************************************************************
 *  Loads all the property from the /config/Manage.properties

 *  @author: Ravi Sankar Karuturi
 *  @createddate: 01/11/2015 
 *****************************************************************************************************/
public  class PropertyFileReader {
	 Properties props;

	public PropertyFileReader() throws FileNotFoundException, IOException{
		 props = new Properties();
         File currentDirFile = new File(".");
 		 String helper = currentDirFile.getAbsolutePath().replace("\\.", "");
         String propertyFilePath = helper+"/config/Manage.properties";
         System.out.println("Loading property file:"+propertyFilePath);
         props.load(new FileInputStream(propertyFilePath));
	}
	
	 public String getProperty(String key)
     {
        String keyValue = props.getProperty(key);
        return keyValue;
     }
	     
}
