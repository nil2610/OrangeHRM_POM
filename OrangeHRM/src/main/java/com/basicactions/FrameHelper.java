package com.basicactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
	
	private WebDriver driver;
	private Logger log = LogHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver) {
		this.driver = driver;
		log.info("********************Created FrameHelper Object********************");
	}
		
//	Switching to frame by frame index
	public void switchToFrame(int frameIndex){
		driver.switchTo().frame(frameIndex);
		log.info("**********Switched to :"+ frameIndex+" frame**********");
	}
	
//	Switching to frame by frame name
	public void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
		log.info("**********Switched to :"+ frameName+" frame**********");
	}
	
//	Switching to frame by WebElement of frame
	public void switchToFrame(WebElement element){
		driver.switchTo().frame(element);
		log.info("Switched to frame "+element.toString());
	}
}
