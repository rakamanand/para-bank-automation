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
	
}
