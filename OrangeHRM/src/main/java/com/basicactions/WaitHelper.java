package com.basicactions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private WebDriver driver;
	private Logger log = LogHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
		log.info("********************Created WaitHelper Object********************");
	}
	
//	Set implicit wait 	
	public void setImplicitWait(long timeout,TimeUnit unit ){
		log.info("Implicit wait has been set to "+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
//  Set page load timeout	
	public void pageLoadTime(long timeout, TimeUnit unit){
		log.info("Waiting for page to load for : "+ timeout+ " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("********************Page is loaded********************");
	}
	
//  Set wait for element is clickable
	public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("********************Element is clickable now********************");
	}

//	Set wait for element is visible 
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("********************Element is visible now********************");
		log.info("element is visible now");
	}

//  Set wait for element is invisible	
	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("********************Element is invisibile now********************");
		return status;
	}

//  Set time for waiting for frame and switch to it	
	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("********************Frame is available and switched to it********************");
	}

//	Get object of WebDriver wait	
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

//  This method help to element is visible with polling timeout	
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
			int pollingEveryInMiliSec) {
		log.info("Waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("********************Element is visible now********************");
	}
	
// 	Get object of fluent wait
	private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}
	
//	Visibility of element with fluent wait	
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
//	Get pause for a milliseconds
	public void pause(int milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
