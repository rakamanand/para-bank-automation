package com.parabank.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parabank.pages.Login;
import com.parabank.utilities.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDef {
	
	WebDriver driver = CommonMethods.driver;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	Login login = new Login(driver);
	
	@Given("I enter {string} and {string} and click login")
	public void i_enter_and(String uname, String pwd) {
	    login.userLogin(uname, pwd);
	}

	@Then("I click on LogOn")
	public void i_click_on_log_on() {
	    
	}
	
}
