package com.parabank.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class CommonMethods {
    public static WebDriver driver;

    public static void openBrowser(String url) {
    	
    	 String browser = ConfigProperties.getProperty("Browser");
    	 System.out.println("Testing in "+browser+" Browser");
         if(browser.contains("Chrome")) {
        	 driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.get(url);
         }
    }
    
    @Given("User is on ParaBank Website")
    public void user_is_on_the_registration_page() {
        String url = CommonConstants.BASE_URL;;
        CommonMethods.openBrowser(url);
        
    }
}
