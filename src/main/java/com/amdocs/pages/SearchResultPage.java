package com.amdocs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.actions.Action;
import com.amdocs.base.Base;

public class SearchResultPage extends Base {
	
	@FindBy(xpath="//*[@id=\"item59c98874f8\"]/div/div[2]/a")
	WebElement firstProductTile;
		
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage selectProduct() throws InterruptedException {
		Action.click(driver, firstProductTile);
		return new ProductPage();
	}

}
