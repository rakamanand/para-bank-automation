package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.parabank.utilities.CommonMethods;

public class AccountServices {
	WebDriver driver = CommonMethods.driver;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[1]")
	public WebElement openNewAccount;
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[2]")
	public WebElement accountOverview;
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[3]")
	public WebElement transferFunds;
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[4]")
	public WebElement billPay;
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[5]")
	public WebElement findTransactions;
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[6]")
	public WebElement updateContactInfo;
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[7]")
	public WebElement requestLoan;
	
	@FindBy(xpath = "//div[@id = 'leftPanel']//ul/li[8]")
	public WebElement logOut;
	
	@FindBy(xpath = "//select[@id = 'type']")
	public WebElement newAccountType;
	
	@FindBy(xpath = "//select[@id = 'fromAccountId']")
	public WebElement existingAccountId;
	
	@FindBy(xpath = "//input[@value = 'Open New Account']")
	public WebElement openNewAccountBtn;
	
	public AccountServices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectOpenNewAccount() {
		wait.until(ExpectedConditions.visibilityOf(openNewAccount));
		openNewAccount.click();
		CommonMethods.capture(driver, "Open New Account");
	}
	
	public void selectAccountOverview() {
		wait.until(ExpectedConditions.visibilityOf(accountOverview));
		accountOverview.click();
		CommonMethods.capture(driver, "Account Overview");
	}
	
	public void selecttransferFunds() {
		wait.until(ExpectedConditions.visibilityOf(transferFunds));
		transferFunds.click();
	}
	
	public void selectBillPay() {
		wait.until(ExpectedConditions.visibilityOf(billPay));
		billPay.click();
	}
	
	public void selectFindTransactions() {
		wait.until(ExpectedConditions.visibilityOf(findTransactions));
		findTransactions.click();
	}
	
	public void selectUpdateContactInfo() {
		wait.until(ExpectedConditions.visibilityOf(updateContactInfo));
		updateContactInfo.click();
	}
	
	public void selectRequestloan() {
		wait.until(ExpectedConditions.visibilityOf(requestLoan));
		requestLoan.click();
	}
	
	public void selectLogOut() {
		wait.until(ExpectedConditions.visibilityOf(logOut));
		logOut.click();
	}
    
	String newAccountNumber = null;
	public void enterAccountDetails(String accountType, String accountId) {
		wait.until(ExpectedConditions.visibilityOf(newAccountType));
		
		Select accType = new Select(newAccountType);
		accType.selectByVisibleText(accountType);
		
//		Select accId = new Select(existingAccountId);
//		accId.selectByVisibleText(accountId);
		existingAccountId.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		
		CommonMethods.capture(driver, "Account Details Entered");
		
		openNewAccountBtn.click();
		
		WebElement accountOpened = driver.findElement(By.xpath("//h1[contains(text(),'Account Opened')]"));
		wait.until(ExpectedConditions.visibilityOf(accountOpened));
		Assert.assertTrue(accountOpened.isDisplayed(), "Account Not opened");
		
		WebElement newAccId = driver.findElement(By.xpath("//a[@id = 'newAccountId']"));
		newAccountNumber = newAccId.getText();
		
		CommonMethods.capture(driver, "Account Created Succesfully");
		
	}
	
	public void selectAccountUsingNumber() {
		
		System.out.println("Account Number:"+newAccountNumber);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String newAcc = "//a[contains(text(),'"+newAccountNumber+"')]";
		WebElement account = driver.findElement(By.xpath(newAcc));
		wait.until(ExpectedConditions.visibilityOf(account));
		
		CommonMethods.scrollIntoView(account);
		
		account.click();
		
		
		WebElement accSuccess = driver.findElement(By.xpath("//h1[contains(text(),'Account Details')]"));
		wait.until(ExpectedConditions.visibilityOf(accSuccess));
		
		Assert.assertTrue(accSuccess.isDisplayed(), "Account Details not visible");
		 
		CommonMethods.capture(driver, "new Account Details");
		
	}
	
}
