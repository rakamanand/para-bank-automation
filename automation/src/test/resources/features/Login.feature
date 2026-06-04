Feature:

  Background:
    Given User is on ParaBank Website
    
  @Login  
  Scenario Outline:
	Given I enter "<username>" and "<password>" and click login
	Then I click on LogOut
	
	Examples:
		|username  |password |
		|john      |demo     |
	