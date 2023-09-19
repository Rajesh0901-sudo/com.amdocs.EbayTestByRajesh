package com.amdocs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.actions.Action;
import com.amdocs.base.Base;

public class IndexPage extends Base {
	
	
	@FindBy(xpath="//*[@id=\"gh-ug\"]/a")
	WebElement signInButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickToSignIn() {
		try {
//			Action.hover(signInDiv);
//			Thread.sleep(2000);
			
			System.out.println("clicking action");
			Action.click(driver, signInButton);
			System.out.println("clicked action");
			
			return new LoginPage();
			
		}catch(Exception e) {
			System.out.println("an error occured while signin button click in indexPage - "+e);
			return null;
		}
	}

}
