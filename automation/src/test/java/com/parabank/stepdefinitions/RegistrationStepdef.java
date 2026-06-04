package com.parabank.stepdefinitions;

import com.parabank.pages.Register;
import com.parabank.utilities.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegistrationStepdef {

	Register register = new Register(CommonMethods.driver);

	@Given("I click On Register")
	public void i_click_on_register() {
		register.clickOnRegister();
	}

	@Then("I enter {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void i_enter(String fName, String lName, String Address, String city, String state, String zipcode,
			String phone, String ssn, String uname, String pwd) {
		register.enterRegistrationData( fName,  lName,  Address,  city,  state,  zipcode,
				 phone,  ssn,  uname,  pwd);
		
	}
}
