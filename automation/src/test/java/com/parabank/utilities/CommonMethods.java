package com.parabank.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class CommonMethods {
    public static WebDriver driver;
    public static String runFolder;
    
    static {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        runFolder = System.getProperty("user.dir")
                + File.separator
                + "screenshots"
                + File.separator
                + "Run_" + timestamp;

        new File(runFolder).mkdirs();
    }
    
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
    
    public static void scrollIntoView(WebElement element) {
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	
    }
    

public static void capture(WebDriver driver, String screenshotName) {

    try {

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destination = new File(
                runFolder + File.separator + screenshotName + ".png"
        );

        Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println("Screenshot saved: "
                + destination.getAbsolutePath());

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    
}
