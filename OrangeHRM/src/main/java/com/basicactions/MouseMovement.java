package com.basicactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MouseMovement{
	
	private WebDriver driver;
	
	
	public MouseMovement(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void mouseHover(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public void mouseHoverClick(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		
	}
	
	public void doubleClick(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
		
	}
		
	public void dragAndDrop(WebElement source,WebElement target ){
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
	}

}
