package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parabank.utilities.CommonConstants;
import com.parabank.utilities.CommonMethods;

public class Login {
	WebDriver driver = CommonMethods.driver;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@FindBy(xpath = "//input[@name = 'username']")
	public WebElement userName;
	
	@FindBy(xpath = "//input[@name = 'password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@value= 'Log In']")
	public WebElement logInBtn;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userLogin(String uname, String pwd) {
		wait.until(ExpectedConditions.visibilityOf(logInBtn));
		
		CommonMethods.capture(driver, "Browser");
		
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		logInBtn.click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		CommonMethods.capture(driver, "Logged In");
		
	}
	
}
