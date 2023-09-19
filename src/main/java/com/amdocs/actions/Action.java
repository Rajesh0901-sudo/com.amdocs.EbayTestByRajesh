package com.amdocs.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.amdocs.base.Base;

public class Action extends Base {

	
	public static void click(WebDriver driver,WebElement ele) {
		
		try {
		
			Actions actClick = new Actions(driver);
			actClick.moveToElement(ele).click().build().perform();
			
		}catch(Exception e) {
			System.out.println("an error occured while click action- "+e);
		}
			
	}
	
	public static boolean enterValue(String value,WebElement ele) {
		
		boolean isElementDisplayed = false;
		
		try {
			isElementDisplayed = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(value);
			isElementDisplayed = true;
			
		}catch(Exception e) {
			
			System.out.println("an error occured while entering value - "+e);
			isElementDisplayed = false;

		}
		
		return isElementDisplayed;
	
	}
	
//	public static boolean hover(WebElement ele) {
//		
//		boolean isElementDisplayed = false;
//		
//		try {
//			isElementDisplayed = ele.isDisplayed();
//			
//			
//			String javascriptCode = "let obj = = document.createEvent( 'MouseEvents' );"
//									+ "obj.initMouseEvent(\"mouseover\",true,false,window);"
//									+ "arguments[0].dispatchEvent(obj)";
//			
//			JavascriptExecutor jsexe = (JavascriptExecutor) driver;
//			jsexe.executeScript(javascriptCode, ele);
//			
//			isElementDisplayed = true;
//			
//			
//		}catch(Exception e) {
//			
//			System.out.println("an error occured while hovering action - "+e);
//			isElementDisplayed = false;
//
//		}
//		
//		return isElementDisplayed;
//		
//	}
	
	public static boolean selectElemntByVisibleValue(WebElement ele,String value) {
		
		boolean isElementDisplayed = false;
		
		try {
			System.out.println("selecting value-"+value);
			isElementDisplayed = ele.isDisplayed();
			
			
			
			Select select =  new Select(ele);
			select.selectByVisibleText(value);	
			isElementDisplayed = true;
			
			System.out.println("selected value-"+value);
			
			
		}catch(Exception e) {
			
			System.out.println("an error occured while hovering action - "+e);
			isElementDisplayed = false;

		}
		
		return isElementDisplayed;
		
	}
	public static boolean selectElemntByValue(WebElement ele,String value) {
		
		boolean isElementDisplayed = false;
		
		try {
			System.out.println("selecting value-"+value);
			isElementDisplayed = ele.isDisplayed();
			
			
			
			Select select =  new Select(ele);
			select.selectByValue(value);	
			isElementDisplayed = true;
			
			System.out.println("selected value-"+value);
			
			
		}catch(Exception e) {
			
			System.out.println("an error occured while hovering action - "+e);
			isElementDisplayed = false;

		}
		
		return isElementDisplayed;
		
	}
	
	
	
	

}



