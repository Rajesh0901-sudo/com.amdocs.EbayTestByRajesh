package com.amdocs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.actions.Action;
import com.amdocs.base.Base;

public class HomePage extends Base {
	
	@FindBy(xpath="//*[@id=\"gh-ac\"]")
	WebElement serachInput;
	
	@FindBy(xpath="//*[@id=\"gh-btn\"]")
	WebElement searchButton;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage search() {
		
		try {
			
			Thread.sleep(2000);
			Action.enterValue(prop.getProperty("product_for_search"), serachInput);
			Thread.sleep(2000);
			Action.click(driver, searchButton);
			
			return new SearchResultPage();
			
		}catch(Exception e) {
			System.out.println("an error occured while searching product in home page - "+e);
			return null;
		}
		
	}

	
}
