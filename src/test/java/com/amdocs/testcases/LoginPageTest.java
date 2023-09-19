package com.amdocs.testcases;




import com.amdocs.base.Base;
import com.amdocs.pages.HomePage;
import com.amdocs.pages.IndexPage;
import com.amdocs.pages.LoginPage;

public class LoginPageTest extends Base {
	
	IndexPage currentIndexPage;
	LoginPage currentLoginPage;
	HomePage currentHomePage;
	

	public void setup() {
		
		luanchTest();
	}
	

	public void quitSetup() {
		driver.quit();
	}
	

	public void IndexSigninClickTest() throws InterruptedException {
		
		Thread.sleep(5000);
		currentIndexPage = new IndexPage();
		currentLoginPage = currentIndexPage.clickToSignIn();
		Thread.sleep(3000);
		currentHomePage = currentLoginPage.clickToSignInButton();
		Thread.sleep(10000);
		
		
	}

}
