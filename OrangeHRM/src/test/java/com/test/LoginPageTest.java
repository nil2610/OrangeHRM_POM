package com.test;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.basicactions.LogHelper;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ReadPropFile;
import com.utilities.ScreenshotUtil;

public class LoginPageTest{

	WebDriver driver;
	Properties prop;
	BaseClass baseClass;
	LoginPage loginPage;
	HomePage homePage;
	ReadPropFile readPropFile;
	Logger log = LogHelper.getLogger(LoginPageTest.class);
	
	
	@BeforeMethod
	public void setUp(){
		log.info("********************setup method start here********************");
		baseClass = new BaseClass();
		readPropFile = new ReadPropFile();
		prop = readPropFile.readProp();
		driver = baseClass.browserLaunchWithURL(prop);
		loginPage = new LoginPage(driver);
		log.info("********************setup method ends here********************");
	}
	
	@Test(priority=1, description ="test1")
	public void verifyLoginPageTitleTest(){
		loginPage = new LoginPage(driver);
		String title = loginPage.getPageTitle();
		System.out.println("the login page title is: "+ title);
	}
	
	@Test(priority=2, description ="test2")
	public void verifyLogo(){
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.getLogo());
		System.out.println("Logo is present");
	}

//	Positive Test
	@Test(priority=3, description ="test3")
	public void LoginTest(){
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(readPropFile.readProp().getProperty("username"), readPropFile.readProp().getProperty("password"));
		homePage = new HomePage(driver);
		String welcome1=homePage.welcomeText();
		System.out.println(welcome1);
		
	}
	
	@DataProvider(name = "Login Details")
	public Object[][] loginDetails() {
	      return new Object[][] {
	    	  {"Admin1","admin123"}
	    	  };
	}

//	Negative Test
	@Test(priority=4, description ="test4", dataProvider = "Login Details")
	public void LoginTest(String Username, String Password){
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(Username, Password);
		homePage = new HomePage(driver);
		String welcome1=homePage.welcomeText();
		System.out.println(welcome1);		
	}
	
	@DataProvider(name = "Login Details1")
	public Object[][] loginDetails1() {
	      return new Object[][] {
	    	  {"Admin","admin123"}, {"Admin","admin1234"}
	    	  };
	}
	
	@Test(priority=5, description ="test5", dataProvider = "Login Details1")
	public void PNLoginTest(String Username, String Password){
		loginPage = new LoginPage(driver);
		loginPage.PNlogin(Username, Password);
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult testResult){
		if(!(testResult.isSuccess())) {
			ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
			screenshotUtil.takeScreenshot();
		}
		log.info("********************teardown method start here********************");
		driver.quit();
		log.info("********************teardown method ends here********************");
	}
}
