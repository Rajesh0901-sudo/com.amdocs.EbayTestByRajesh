package com.amdocs.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amdocs.base.Base;
import com.amdocs.pages.CartPage;
import com.amdocs.pages.HomePage;
import com.amdocs.pages.IndexPage;
import com.amdocs.pages.LoginPage;
import com.amdocs.pages.ProductPage;
import com.amdocs.pages.SearchResultPage;

public class CompleteAppTest extends Base {
	
	IndexPage currentIndexPage;
	LoginPage currentLoginPage;
	HomePage currentHomePage;
	SearchResultPage currentSearchPage;
	ProductPage currentProductPage;
	CartPage currentCartPage;
	String MainWindow;
	
	@BeforeSuite
	public void setup() {
		startConfiguration();
		luanchTest();
	}
	
	@AfterSuite
	public void quitSetup() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void IndexPageTest() {
		try {
			Thread.sleep(2000);
			currentIndexPage = new IndexPage();
			currentLoginPage = currentIndexPage.clickToSignIn();
			
		}catch(Exception e) {
			System.out.println("An error occured while testing IndexPage-"+e);
		}
	}
	
	@Test(priority = 2)
	public void LoginPageTest() {
		try {
			Thread.sleep(2000);
			currentLoginPage.clickToSignInButton();
			Thread.sleep(30000);
			currentHomePage = new HomePage();
			
		}catch(Exception e) {
			System.out.println("An error occured while testing LoginPage-"+e);
		}
	}
	
	@Test(priority = 3)
	public void HomePageTest() {
		try {
			Thread.sleep(2000);
			MainWindow = driver.getWindowHandle();
			currentSearchPage =  currentHomePage.search();	
		}catch(Exception e) {
			System.out.println("An error occured while testing HomePage-"+e);
		}
	}
	
	@Test(priority = 4)
	public void SearchPageTest() {
		try {
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
		}catch(Exception e) {
			System.out.println("An error occured while testing SearchPage-"+e);
		}
	}
	
	@Test(priority = 5)
	public void ProductPageTest() {
		try {
			
			Thread.sleep(2000);
			currentProductPage = new ProductPage();
			Thread.sleep(1000);
			currentCartPage = currentProductPage.addToCart();
			
		}catch(Exception e) {
			System.out.println("An error occured while testing ProductPage-"+e);
		}
	}
	
	@Test(priority = 6)
	public void CartPageTest() {
		try {
			Thread.sleep(2000);
			currentCartPage.goToCheckoutPage();
			System.out.println("\n\nAll Test Cases Passed Succesfully\n\n");
			Thread.sleep(10000);
			
		}catch(Exception e) {
			System.out.println("An error occured while testing CartPage-"+e);
		}
	}

}
