package com.basicactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxRadioButtonHelper {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	private Logger log = LogHelper.getLogger(CheckBoxRadioButtonHelper.class);
	
	public CheckBoxRadioButtonHelper(WebDriver driver) {
		this.driver = driver;
		log.info("********************Created CheckBoxRadioButtonHelper Object********************");
	}
	
	public boolean isSlected(WebElement element){
		boolean flag = element.isSelected();
		return flag;
	}
	
	public void selectCheckBox(WebElement element) {
		log.info("********************Select element(Radio button or Check Box)********************");
		if(!isSlected(element))
			element.click();
	}
	
	public void unSelectCheckBox(WebElement element) {
		log.info("********************Deselect element(Radio button or Check Box)********************");
		if(isSlected(element))
			element.click();
	}

}
