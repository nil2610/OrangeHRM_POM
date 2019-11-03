package com.basicactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

	private WebDriver driver;
	private Logger log = LogHelper.getLogger(NavigationHelper.class);
	
	public NavigationHelper(WebDriver driver){
		this.driver = driver;
		log.info("********************Created NavigationHelper Object********************");
	}
	
	public String getTitle(){
		String pageTitle = driver.getTitle();
		log.info("********************"+ pageTitle + "********************");
		return pageTitle;
	}
	
	public String getCurrentUrl(){
		String currentURL = driver.getCurrentUrl();
		log.info("Current URL is :"+ currentURL);
		return currentURL;
	}
	
	public void refreshPage(){
		driver.navigate().refresh();
		log.info("********************Page get refreshed********************");
	}
	
	public void navigateBack(){
		log.info("********************Navigate to back page********************");
		driver.navigate().back();
	}
	
	public void navigateForward(){
		log.info("********************Navigate to forward page********************");
		driver.navigate().forward();
	}
	
	public void navigateURL(String url){
		log.info("Navigate to URL:" + url);
		driver.navigate().to(url);
	}

}
