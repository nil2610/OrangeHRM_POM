package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basicactions.DropDownHelper;
import com.utilities.ElementUtil;

public class AdminPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	DropDownHelper dropDownHelper;
	
	By adminmenu = By.xpath("//a[(contains(@id,'menu_admin') and @class='arrow') or contains(text(), 'Nationalities')]");
	By addbtn = By.xpath("//input[@id='btnAdd']");
	By selectRole = By.xpath("//select[@id='systemUser_userType']");
	By employeeName = By.xpath("//input[@id='systemUser_employeeName_empName']");
	By userName = By.xpath("//input[@id='systemUser_userName']");
	By passWord = By.xpath("//input[@id='systemUser_password']");
	By coPassWord = By.xpath("//input[@id='systemUser_confirmPassword']");
	By savebtn = By.xpath("//input[@id='btnSave']");
	By serachUser = By.xpath("//input[@id='searchSystemUser_userName']");
	By searchbtn = By.xpath("//input[@id='searchBtn']");
	By selectCheckBox = By.xpath("//*[@name='chkSelectRow[]']");
	By deleteBtn = By.xpath("//input[@id='btnDelete']");
	By conDelete = By.xpath("//input[@id='dialogDeleteBtn']");
	
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		dropDownHelper = new DropDownHelper(driver);
	}
	
	public void adminMenu() {
		java.util.List<WebElement> elements = elementUtil.getElements(adminmenu);
		for(WebElement e: elements) {
			System.out.println(e.getText());
		}
	}
		
	public void addNewUser() throws InterruptedException {		
		elementUtil.getElement(addbtn).click();
		WebElement role =  elementUtil.getElement(selectRole);
		dropDownHelper.selectVisibleText(role, "ESS");
		elementUtil.getElement(employeeName).sendKeys("John Smith");
		elementUtil.getElement(userName).sendKeys("newtestuser2");
		elementUtil.getElement(passWord).sendKeys("newtesting@123");
		elementUtil.getElement(coPassWord).sendKeys("newtesting@123");
		elementUtil.getElement(savebtn).click();
		Thread.sleep(5000);
	
	}
	
	public void searchCreatedUser() {
		elementUtil.getElement(serachUser).sendKeys("newtestuser2");
		elementUtil.getElement(searchbtn).click();
		
		
	}

	public void deletUser() throws InterruptedException {
		elementUtil.getElement(selectCheckBox).click();
		elementUtil.getElement(deleteBtn).click();
		Thread.sleep(2000);
		elementUtil.getElement(conDelete).click();
		
	}
}

