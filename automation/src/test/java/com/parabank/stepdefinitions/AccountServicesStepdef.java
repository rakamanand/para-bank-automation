package com.parabank.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.parabank.pages.AccountServices;
import com.parabank.utilities.CommonMethods;

import io.cucumber.java.en.Then;

public class AccountServicesStepdef {

	WebDriver driver = CommonMethods.driver;
	AccountServices services = new AccountServices(driver);
	
	
	@Then("I click on LogOut")
	public void I_Click_on_LogOut() {
		services.selectLogOut();
	}
	
	@Then("I select open new account")
	public void I_select_open_new_account() {
		services.selectOpenNewAccount();	
	}
	
	@Then("I select {string} and {string} and create new account")
	public void I_select_accountType_and_accountNmbr(String accountType,String accountId) {
		services.enterAccountDetails(accountType, accountId);
	}
	
	@Then("I select account overview")
	public void I_select_account_overview() {
		services.selectAccountOverview();
	}
	
	@Then("I select created Account and check Details are visible")
	public void check_acc_details_visible() {
		services.selectAccountUsingNumber();
	}
}
