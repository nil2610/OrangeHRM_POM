package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basicactions.MouseMovement;
import com.utilities.ElementUtil;

public class HomePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	MouseMovement mouseMovement;
	AdminPage adminPage;
	
	By welcome = By.xpath("//a[@id='welcome']");
	By menu = By.xpath("//a[contains(@class,'firstLevelMenu')]");
	By admin = By.xpath("//b[contains(text(),'Admin')]");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		mouseMovement = new MouseMovement(driver);
	}
	
	
	public String welcomeText() {
		String welcometext = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		return welcometext;
	}

	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public void firstLevelMenu() {
		java.util.List<WebElement> elements = elementUtil.getElements(menu);
		for(WebElement e: elements) {
			System.out.println(e.getText());
		}
	}
	
	
	public AdminPage navigateToAdminPage() {
		mouseMovement.mouseHoverClick(elementUtil.getElement(admin));
		return adminPage;
	}
	
}
