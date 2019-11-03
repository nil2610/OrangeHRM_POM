package com.utilities;

public class FilesPaths {
		
	public final static String CONFIG_PROPERTIES_FILE = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\configfiles\\config.properties";
	
	public final static String LOG_PROPERTIES_FILE= System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\configfiles\\log4j.properties";
		
	public final static String CHROME_DRIVER = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\chromedriver.exe";
	
	public final static String GECKO_DRIVER_FF = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\geckodriver.exe";
	
	public final static String IE_DRIVER = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\IEDriverServer.exe";
	
}