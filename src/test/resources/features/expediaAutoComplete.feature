@regression @autocomplete
Feature: Verify auto complete list  

  Background: 
    Given I am on Expedia home page

  @autocomplete 
  Scenario: insert a city name in flying from field and pick the airport from auto suggestion list 
    When I click on Flight tab on home page 
    And I click on Flying from field on home page 
    And I insert new york into Flying from field on home page
    And I click on JFK airport from list 
    Then I verify JFK airport has been selected