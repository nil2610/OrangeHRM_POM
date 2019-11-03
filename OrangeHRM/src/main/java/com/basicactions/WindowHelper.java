package com.basicactions;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHelper {
	
	private WebDriver driver;
	private Logger log = LogHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver){
		this.driver = driver;
		log.info("********************Created WindowHelper Object********************");
	}
	
	public void switchToParentWindow() {
		log.info("********************Switching to parent window********************");
		driver.switchTo().defaultContent();
	}
		
//	Switch to child window by index 	
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				log.info("Switched to : "+index + " window");
				driver.switchTo().window(window);
			} else {
				i++;
			}
		}
	}

//	Closed all tab window and switch to main window	
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}
		}
		log.info("switched to main window");
		driver.switchTo().window(mainwindow);
	}
}