package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ReadPropFile;

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BaseClass baseClass;
	LoginPage loginPage;
	HomePage homePage;
	ReadPropFile readPropFile;
	
	@BeforeMethod
	public void setUp(){
		baseClass = new BaseClass();
		readPropFile = new ReadPropFile();
		prop = readPropFile.readProp();
		driver = baseClass.browserLaunchWithURL(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(readPropFile.readProp().getProperty("username"), readPropFile.readProp().getProperty("password"));
		homePage = new HomePage(driver);
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		homePage = new HomePage(driver);
		String title = homePage.getHomePageTitle();
		System.out.println("the home page title is: "+ title);
	}
	
	@Test(priority=2)
	public void listMenu(){
		homePage = new HomePage(driver);
		homePage.firstLevelMenu();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
