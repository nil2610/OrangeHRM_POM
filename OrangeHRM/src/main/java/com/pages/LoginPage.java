package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.utilities.ElementUtil; 

public class LoginPage extends BaseClass{
	
	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	
	By username = By.xpath("//input[@id='txtUsername']");
	By password = By.xpath("//input[@id='txtPassword']");
	By loginbtn = By.xpath("//input[@id='btnLogin']");
	By logo = By.xpath("//div[@id='divLogo']//img");
	By welcome = By.xpath("//a[@id='welcome']");
	By errmsg = By.xpath("//span[@id='spanMessage']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean getLogo() {
		 return elementUtil.getElement(logo).isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		elementUtil.getElement(username).sendKeys(un);
		elementUtil.getElement(password).sendKeys(pw);
		elementUtil.getElement(loginbtn).click();
		return homePage;
	}
	
	public void PNlogin(String un, String pw) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pw);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
				
		Boolean isPresent = driver.findElements(By.xpath("//input[@id='btnLogin']")).size()>0;	
		if(isPresent == true){
			System.out.println("Login failed");
		}else {
			System.out.println("Login Done");
		}
	}
}
