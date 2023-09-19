package com.amdocs.testcases;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amdocs.base.Base;
import com.amdocs.pages.HomePage;
import com.amdocs.pages.IndexPage;
import com.amdocs.pages.LoginPage;
import com.amdocs.pages.ProductPage;
import com.amdocs.pages.SearchResultPage;

public class ProductPageTest extends Base {
	IndexPage currentIndexPage;
	LoginPage currentLoginPage;
	HomePage currentHomePage;
	SearchResultPage currentSearchPage;
	ProductPage currentProductPage;
	
	@BeforeMethod
	public void setup() {
		
		luanchTest();
	}
	
	@AfterMethod
	public void quitSetup() {
		driver.quit();
	}
	
	@Test
	public void searchHomePageTest() throws InterruptedException {
		
		Thread.sleep(2000);
		currentIndexPage = new IndexPage();
		currentLoginPage = currentIndexPage.clickToSignIn();
		Thread.sleep(1000);
		currentHomePage = currentLoginPage.clickToSignInButton();
		Thread.sleep(1000);
		currentSearchPage =  currentHomePage.search();
		Thread.sleep(1000);
		currentSearchPage.selectProduct();
//		Thread.sleep(5000);
//		
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
//		
//		Thread.sleep(1000);
//		
//		currentProductPage = new ProductPage();
//		Thread.sleep(1000);
//		currentProductPage.addToCart();
		Thread.sleep(10000);
		
		
	}

}
