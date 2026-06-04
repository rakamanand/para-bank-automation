package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parabank.utilities.CommonMethods;

public class Register {
	WebDriver driver = CommonMethods.driver;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	public WebElement registerLink;
	
	@FindBy(xpath ="//input[@id = 'customer.firstName']")
	public WebElement firstName;
	
	@FindBy(xpath ="//input[@id = 'customer.lastName']")
	public WebElement lastName;
	
	@FindBy(xpath ="//input[@id = 'customer.address.street']")
	public WebElement address;
	
	@FindBy(xpath ="//input[@id = 'customer.address.city']")
	public WebElement city;
	
	@FindBy(xpath ="//input[@id = 'customer.address.state']")
	public WebElement state;
	
	@FindBy(xpath ="//input[@id = 'customer.address.zipCode']")
	public WebElement zipcode;
	
	@FindBy(xpath ="//input[@id = 'customer.phoneNumber']")
	public WebElement phone;
	
	@FindBy(xpath ="//input[@id = 'customer.ssn']")
	public WebElement ssn;
	
	@FindBy(xpath ="//input[@id = 'customer.username']")
	public WebElement userName;
	
	@FindBy(xpath ="//input[@id = 'customer.password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@id = 'repeatedPassword']")
	public WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@value = 'Register']")
	public WebElement submitRegisterButton;
	
	public Register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRegister() {
		wait.until(ExpectedConditions.visibilityOf(registerLink));
		registerLink.click();
		System.out.println("Clicked on Register");
	}

	public void enterRegistrationData(String fName, String lName, String address, String city, String state,
			String zipcode, String phone, String ssn, String uname, String pwd) {
		wait.until(ExpectedConditions.visibilityOf(submitRegisterButton));
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.zipcode.sendKeys(zipcode);
		this.phone.sendKeys(phone);
		this.ssn.sendKeys(ssn);
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		
		submitRegisterButton.click();
		
		
		
		
		
	}
}
