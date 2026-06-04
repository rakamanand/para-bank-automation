package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public AccountServices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectOpenNewAccount() {
		wait.until(ExpectedConditions.visibilityOf(openNewAccount));
		openNewAccount.click();
	}
	
	public void selectAccountOverview() {
		wait.until(ExpectedConditions.visibilityOf(accountOverview));
		accountOverview.click();
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
}
