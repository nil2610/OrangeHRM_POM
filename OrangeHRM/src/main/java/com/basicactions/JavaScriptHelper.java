package com.basicactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
	
	private WebDriver driver;
	private Logger log = LogHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("********************Created JavaScriptHelper Object********************");
	}

//	Execute JavaScript 
	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

//	Execute JavaScript with multiple arguments
	public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
//	Scroll to the element
	public void scrollToElement(WebElement element){
		log.info("********************Scroll to element********************");
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,element.getLocation().y);
	}

//	Scroll to element and click on that
	public void scrollToElementAndClick(WebElement element){
		scrollToElement(element);
		element.click();
		log.info("Element is clicked: "+element.toString());
	}
	
//	Scroll till element view
	public void scrollIntoView(WebElement element){
		log.info("********************Scroll  till web element********************");
		executeScript("arguments[0].scrollIntoView()",element);
	}
	
//	Scroll till element view and click
	public void scrollIntoViewAndClick(WebElement element){
		scrollIntoView(element);
		element.click();
		log.info("Scroll to element is view and clicked: "+element.toString());
	}

//	Scroll down vertically
	public void scrollDownVertically(){
		log.info("********************Scrolling down vertically********************");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

//	Scroll up vertically
	public void scrollUpVertically(){
		log.info("********************Scrolling up vertically********************");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
//	Scroll till to given pixel(e.g. pixel = 1000)
	public void scrollDownByPixel(int pixel){
		log.info("********************Scrolling till to given pixel********************");
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel){
		executeScript("window.scrollBY(0,-"+pixel+")");
	}

//	Zooming screen by 100%
	public void zoomInBy100Percentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	
//	Zooming screen by 60%
	public void zoomInBy60Percentage(){
		log.info("********************Zooming by 60%********************");
		executeScript("document.body.style.zoom='40%'");
	}
	
//	Click on element by JavaScript
	public void clickElement(WebElement element){
		log.info("********************Clicking on element********************");
		executeScript("arguments[0].click();", element);
	}
	

}
