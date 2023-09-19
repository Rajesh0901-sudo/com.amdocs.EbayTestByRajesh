package com.amdocs.base;

import java.util.Properties;
import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait ;
	
	
	public void startConfiguration() {
		
		// starting configuration
		
		try {
			prop = new Properties();
			
			//reading from file Config.properties
			FileInputStream fip = new FileInputStream( System.getProperty("user.dir") + "/Configuration/Configrations.properties" );
			
			//loading the data to prop variable
			prop.load(fip);
			
			System.out.println("current driver is - "+driver +  prop.getProperty("browser_name"));
		}
		catch(Exception e) {
			System.out.println("an error occured while configuration- "+ e);
		}
	}
	

	public void luanchTest() {
		
		try {	
		
			String browserName = prop.getProperty("browser_name");
			
			if(browserName.contains("safari")) {
				
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				
			}else if(browserName.contains("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
			}else if(browserName.contains("edge")) {
				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				
			}else {
				System.out.println("an error occured while getting driver- ");
			}
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.get(prop.getProperty("websiteUrl"));
			
			wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			
			
			
		}catch(Exception e) {
			System.out.println("an error occured while launching Test" + e);
		}
		
		
	}
	
 
}
