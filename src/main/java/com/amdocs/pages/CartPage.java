package com.amdocs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.actions.Action;
import com.amdocs.base.Base;

public class CartPage extends Base {
	
	@FindBy(xpath="//*[@id=\"mainContent\"]/div/div[2]/div[2]/div/div[1]/button")
	WebElement goToCheckoutButton;
			
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void goToCheckoutPage() throws InterruptedException {
		Thread.sleep(3000);
		Action.click(driver, goToCheckoutButton);
		Thread.sleep(1000);
	}

}
