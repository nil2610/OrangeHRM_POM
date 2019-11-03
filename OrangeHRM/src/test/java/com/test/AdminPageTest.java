package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.AdminPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ReadPropFile;

public class AdminPageTest {
	
	WebDriver driver;
	Properties prop;
	BaseClass baseClass;
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
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
		adminPage = homePage.navigateToAdminPage();
		adminPage = new AdminPage(driver);
	}
	
	@Test(priority=1)
	public void listAdminMenu(){
		adminPage.adminMenu();
	}
	
	@Test(priority=2)
	public void addUser() throws InterruptedException{
		adminPage.addNewUser();
		adminPage.searchCreatedUser();
		adminPage.deletUser();
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
