package com.amdocs.testcases;



import com.amdocs.base.Base;
import com.amdocs.pages.IndexPage;
import com.amdocs.pages.LoginPage;

public class IndexPageTest extends Base {

	IndexPage currentIndexPage;
	LoginPage currentLoginPage;
	

	public void setup() {
		
		luanchTest();
	}

	public void quitSetup() {
		driver.quit();
	}
	

	void IndexSigninClickTest() throws InterruptedException {
		
		Thread.sleep(1000);
		currentIndexPage = new IndexPage();
		currentLoginPage = currentIndexPage.clickToSignIn();
		Thread.sleep(5000);
		
		
	}

}
