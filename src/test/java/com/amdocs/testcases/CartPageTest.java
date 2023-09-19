package com.amdocs.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amdocs.base.Base;
import com.amdocs.pages.CartPage;
import com.amdocs.pages.HomePage;
import com.amdocs.pages.IndexPage;
import com.amdocs.pages.LoginPage;
import com.amdocs.pages.ProductPage;
import com.amdocs.pages.SearchResultPage;

public class CartPageTest extends Base {
	
	IndexPage currentIndexPage;
	LoginPage currentLoginPage;
	HomePage currentHomePage;
	SearchResultPage currentSearchPage;
	ProductPage currentProductPage;
	CartPage currentCartPage;
	
	@BeforeMethod
	public void setup() {
		startConfiguration();
		luanchTest();
	}
	
	@AfterMethod
	public void quitSetup() {
		driver.quit();
	}
	
	@Test
	public void searchHomePageTest() throws InterruptedException {
		
//		Thread.sleep(2000);
//		currentIndexPage = new IndexPage();
//		currentLoginPage = currentIndexPage.clickToSignIn();
//		Thread.sleep(1000);
//		currentHomePage = currentLoginPage.clickToSignInButton();
//		Thread.sleep(1000);
		
		currentHomePage = new HomePage();
		
		String MainWindow = driver.getWindowHandle();
		
		currentSearchPage =  currentHomePage.search();	
		
		Thread.sleep(2000);
		
		currentSearchPage.selectProduct();
		
		Thread.sleep(2000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		Iterator<String> iterator1 = tabs.iterator();
		
		while(iterator1.hasNext()) {
			String getWindow = iterator1.next();
			
			System.out.println("\n\n");
			System.out.println(getWindow);
			System.out.println("\n\n");
			
			if(!MainWindow.equalsIgnoreCase(getWindow)) {
				driver.switchTo().window(getWindow);	
			}
		}
					
		
		Thread.sleep(2000);			
		currentProductPage = new ProductPage();
		
		Thread.sleep(1000);
		
		currentCartPage = currentProductPage.addToCart();
		Thread.sleep(1000);
		
		currentCartPage.goToCheckoutPage();
		Thread.sleep(10000);
		
		
	}

}
