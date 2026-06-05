
Feature: Developing E2E Scenario 

@E2E
Scenario Outline:
	Given I enter "<username>" and "<password>" and click login
	Then I select open new account
	Then I select "<accountType>" and "<existingAccountId>" and create new account
	Then I select account overview
	Then I select created Account and check Details are visible
	
	
	#Then I click on LogOut
	
	Examples:
		|username  |password |existingAccountId| accountType |
		|john      |demo     |12456			   |SAVINGS |