package com.amdocs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.actions.Action;
import com.amdocs.base.Base;

public class LoginPage extends Base {
	
	
	@FindBy(xpath="//*[@id=\"userid\"]")
	WebElement emailInput;
	
	@FindBy(xpath="//*[@id=\"pass\"]")
	WebElement passwordInput;
	
	@FindBy(xpath="//*[@id=\"signin-continue-btn\"]")
	WebElement continueWithMailButton;
	
	@FindBy(xpath="//*[@id=\"sgnBt\"]")
	WebElement signInButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickToSignInButton() {
		try {
			
			Thread.sleep(2000);
			Action.enterValue(prop.getProperty("user_email"),emailInput);
			Thread.sleep(2000);
			Action.click(driver, continueWithMailButton);
			Thread.sleep(2000);
			Action.enterValue(prop.getProperty("password"), passwordInput);
			Thread.sleep(2000);
			Action.click(driver, signInButton);
			
			return new HomePage();
			
		}catch(Exception e) {
			System.out.println("an error occured while signin button click in LoginPage - "+e);
			return null;
		}
	}
}
