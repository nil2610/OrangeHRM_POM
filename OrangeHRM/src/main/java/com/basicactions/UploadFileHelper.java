package com.basicactions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class UploadFileHelper {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	public Robot robot;
	private Logger log = Logger.getLogger(AlertHelper.class);
	
	public UploadFileHelper(WebDriver driver){
		this.driver = driver;
		log.info("********************Created UploadFileHelper Object********************");
	}
	
	public void uploadFile(String uploadFilePath) throws Exception{
		
		robot = new Robot();
		robot.setAutoDelay(2000);
		
		log.info("********************Copy text********************");
		StringSelection stringSelection = new StringSelection(uploadFilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.setAutoDelay(1000);
		log.info("********************Paste text********************");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		log.info("********************Press Enter********************");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}

}
