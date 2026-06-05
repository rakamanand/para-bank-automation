package com.parabank.runner;

import com.parabank.utilities.CommonConstants;
import com.parabank.utilities.CommonMethods;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.parabank",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = "@E2E"
)

public class TestRunner extends AbstractTestNGCucumberTests {
    
	@Before
	public void setUp() {
		CommonMethods.openBrowser(CommonConstants.BASE_URL);
	}
	
}
