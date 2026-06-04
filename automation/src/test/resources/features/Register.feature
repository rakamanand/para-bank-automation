@rullAll
Feature: Registration Form

  Background:
    Given User is on ParaBank Website

  @Register
  Scenario Outline:
    Given I click On Register
    Then I enter "<fName>" "<lName>" "<Address>" "<city>" "<state>" "<zipcode>" "<phone>" "<ssn>" "<uname>" "<pwd>"
    

    Examples:
      | fName | lName | Address | city | state     | zipcode | phone         | ssn      | uname | pwd       |
      | raj   | kumar | Lng     | Nkd  | Telangana | 506122  | +917878123411 | 12345676 | amigo | amigo@123 |
