package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.basicactions.LogHelper;

public class ReadPropFile {
	
	public Properties prop;
	Logger log = LogHelper.getLogger(ReadPropFile.class);
	
	public Properties readProp() {
		prop = new Properties();
		log.info("********************Initialization of properties file********************");
		try {
			FileInputStream fi = new FileInputStream(FilesPaths.CONFIG_PROPERTIES_FILE);
			prop.load(fi);
			log.info("********************Loading of properties file********************");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
