package com.amdocs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.actions.Action;
import com.amdocs.base.Base;

public class ProductPage extends Base {
	
	@FindBy(xpath="//*[@id=\"x-msku__select-box-1000\"]")//*[@id="x-msku__select-box-1001"]
	WebElement selectColor;
		
	@FindBy(xpath="//*[@id=\"x-msku__select-box-1001\"]")
	WebElement selectSize;
	
	@FindBy(xpath="//*[@id=\"mainContent\"]/div[2]/div/div[1]/div[2]/ul/li[2]/div/a")
	WebElement addToCart;
		
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public CartPage addToCart() throws InterruptedException {
		
		try {
			System.out.println("clicking on add to cart");
			Thread.sleep(2000);
			Action.selectElemntByValue(selectColor, "0");
			Thread.sleep(2000);
			Action.selectElemntByValue(selectSize, "1");
			Thread.sleep(2000);
			Action.click(driver, addToCart);
			return new CartPage();
			
			
		}catch(Exception e) {
			System.out.print("an error occurend while selecting things-"+e);
			return null;
		}
		
		
	}
	

}
