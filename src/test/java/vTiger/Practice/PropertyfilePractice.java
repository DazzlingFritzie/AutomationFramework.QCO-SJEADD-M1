package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfilePractice {
	
	public static void Properties_file() throws IOException {
		
		//steps 1: Load the file into file input stream to make it java readable
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			
		//step 2: create an obj of property file from java.util package
		Properties pro=new Properties();
		
		//step 3: load fileinput stream in to properties
		pro.load(fis);
		
		//step 4: fetch the data using key
		String BROWSER=pro.getProperty("browser");
		System.out.println(BROWSER);
	    String URL=pro.getProperty("url");
		System.out.println(URL);

	}

}
