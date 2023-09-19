package com.amdocs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.actions.Action;
import com.amdocs.base.Base;

public class CheckoutPage extends Base {

	@FindBy(xpath="//*[@id=\"payment-selection-fieldset\"]/div[2]")
	WebElement payPallInputCheck;
	
	@FindBy(xpath="//*[@id=\"page-form\"]/div/button")
	WebElement payWithPallButton;
		
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void goToCheckoutPage() {
		
		try {
			
			Action.click(driver, payPallInputCheck);
			Thread.sleep(1000);
			Action.click(driver, payWithPallButton);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
