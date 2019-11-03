package com.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.basicactions.LogHelper;
import com.utilities.FilesPaths;
import com.utilities.TimeOutWait;


public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	Logger log = LogHelper.getLogger(BaseClass.class);
			
	public WebDriver browserLaunchWithURL(Properties prop){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")){
			log.info("********************Initializing chrome browser********************");
			System.setProperty("webdriver.chrome.driver", FilesPaths.CHROME_DRIVER);	
			driver = new ChromeDriver();
			log.info("********************Initialized chrome browser********************");
		}
		else if(browserName.equalsIgnoreCase("FF")){
			log.info("********************Initializing firefox browser********************");
			System.setProperty("webdriver.gecko.driver", FilesPaths.GECKO_DRIVER_FF);	
			driver = new FirefoxDriver();
			log.info("********************Initialized firefox browser********************");
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			log.info("********************Initializing internet explorer browser********************");
			System.setProperty("webdriver.gecko.driver", FilesPaths.IE_DRIVER);
			driver = new InternetExplorerDriver();
			log.info("********************Initialized internet explorer browser********************");
		}else {
			log.info("********************Invalid browser name********************");
			System.out.println(browserName + ": is not proper browser name ");
			try {
				throw new Exception("No Browser found exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		driver.manage().window().maximize();
		log.info("********************Window maximized********************");
		driver.manage().deleteAllCookies();
		log.info("********************Deleted all cookies********************");
		driver.manage().timeouts().pageLoadTimeout(TimeOutWait.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOutWait.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		log.info("********************URL pass to browser********************");
		driver.get(prop.getProperty("url"));
				
		return driver;
	}

}