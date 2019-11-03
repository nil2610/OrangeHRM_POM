package com.basicactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	
	private WebDriver driver;
	private Logger log = LogHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver){
		this.driver = driver;
		log.info("********************Created AlertHelper Object********************");
	}
	
	public Alert getAlert(){
		log.info("********************Switch to  Alert********************");
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		getAlert().accept();
		log.info("********************Alert accepted********************");
	}
	
	public void dismissAlert(){
		getAlert().dismiss();
		log.info("********************Alert dismissed********************");
	}
	
	public String getText(){
		String alertText = getAlert().getText();
		log.info("********************Alert text message********************");
		return alertText;
	}
	
	public void sendKeyToAlert(String textToAlert){
		getAlert().sendKeys(textToAlert);
		log.info("********************Text message write to Alert********************");
	}

}
