package com.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basicactions.LogHelper;

public class ElementUtil{
	
	private WebDriver driver;
	Logger log = LogHelper.getLogger(ElementUtil.class);
	
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		log.info("********************Created ElementUtil Object********************");
	}

	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		}catch (Exception e) {
			System.out.println("Some exception occurred while creating webelement " + locator);
		}
		return element;
	}
	
	public java.util.List<WebElement> getElements(By locator) {
		waitForElementPresent(locator);
		java.util.List<WebElement> elements  = null;
		try {
			elements = driver.findElements(locator);
						
		}catch (Exception e) {
			System.out.println("Some exception occurred while creating webelement " + locator);
		}
		return elements;
	}
	
	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
