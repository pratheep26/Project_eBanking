package com.eBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	public ReadConfig()
	{
		File src=new File("./Configuration\\config.properties");

		try {
			FileInputStream fis=new FileInputStream(src);
			properties=new Properties();
			properties.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is :"+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=properties.getProperty("baseURL");
		return url;
	}

	public String setUsername()
	
	{
		String username=properties.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=properties.getProperty("password");
		return password;
	}
	
	public String getChrompath()
	{
		String chrompath=properties.getProperty("chrompath");
		return chrompath;
	}
	
	public String getIEpath()
	{
		String iepath=properties.getProperty("IEpath");
		return iepath;
	}
	
	public String getFirefoxpath()
	{
		String firefoxpath=properties.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	
	
	
	
	
	
	
	
	
}
