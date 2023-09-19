package com.amdocs.testcases;

import com.amdocs.base.Base;
import com.amdocs.pages.HomePage;
import com.amdocs.pages.IndexPage;
import com.amdocs.pages.LoginPage;
import com.amdocs.pages.SearchResultPage;

public class HomePageTest extends Base {
	
	IndexPage currentIndexPage;
	LoginPage currentLoginPage;
	HomePage currentHomePage;
	SearchResultPage currentSearchPage;
	

	public void setup() {
		
		luanchTest();
	}
	

	public void quitSetup() {
		driver.quit();
	}
	

	public void searchHomePageTest() throws InterruptedException {
		
		Thread.sleep(5000);
		currentIndexPage = new IndexPage();
		currentLoginPage = currentIndexPage.clickToSignIn();
		Thread.sleep(3000);
		currentHomePage = currentLoginPage.clickToSignInButton();
		Thread.sleep(2000);
		currentSearchPage =  currentHomePage.search();
		Thread.sleep(10000);
		
		
	}

}
