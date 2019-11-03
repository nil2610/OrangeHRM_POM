package com.basicactions;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	private Logger log = LogHelper.getLogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver){
		this.driver = driver;
		log.info("********************Created DropDownHelper Object********************");
	}
	
	public void selectByVaule(WebElement element, String value){
		Select select = new Select(element);
		log.info("Selection using in dropdown by "+value+" value");
		select.selectByValue(value);
	}
	
	public void selectByIndex(WebElement element, int index){
		Select select = new Select(element);
		log.info("Selection using in dropdown by "+index+" index");
		select.selectByIndex(index);
	}
	
	public void selectVisibleText(WebElement element, String visibleText){
		Select select = new Select(element);
		log.info("Selection using in dropdown by "+visibleText);
		select.selectByVisibleText(visibleText);
	}
	
	public void deselectByVaule(WebElement element, String value){
		Select select = new Select(element);
		log.info("Deselection using in dropdown by "+value+" value");
		select.deselectByValue(value);
	}
	
	public void deselectByIndex(WebElement element, int index){
		Select select = new Select(element);
		log.info("Deselection using in dropdown by "+index+" index");
		select.deselectByIndex(index);
	}
	
	public void deselectVisibleText(WebElement element, String visibleText){
		Select select = new Select(element);
		log.info("Deselection using in dropdown by "+visibleText);
		select.deselectByVisibleText(visibleText);
	}
	
	public boolean isMultiple(WebElement element){
		Select select =new Select(element);
		log.info("********************Cheking dropdown is multiple or not********************");
		boolean isMultiple = select.isMultiple();
		return isMultiple;
	}
	
	public void deselectAll(WebElement element){
		Select select = new Select(element);
		log.info("********************Deselection of all selected value********************");
		select.deselectAll();
	}
	
	public WebElement getFirstSelectedOption(WebElement element){
		Select select = new Select(element);
		log.info("********************Get first selected element********************");
		WebElement getFirstSelectedOption = select.getFirstSelectedOption();
		return getFirstSelectedOption;
	}
	
	public List<String> getAllDropDownData(WebElement element){
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for(WebElement ele: elementList){
			log.info("List of options: "+ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}
	
	public List<String> getAllSelectData(WebElement element){
		Select select = new Select(element);
		List<WebElement> elementList = select.getAllSelectedOptions();
		List<String> valueList = new LinkedList<String>();
		for(WebElement ele : elementList){
			log.info("List of all selected data: "+ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}
}
