@regression @signup
Feature: Verify Signup Feature

  Background:
    Given I am on facebook home page

  @signup-fb
  Scenario Outline: Verify invalid signup
    When I enter <fname> into firstname text fields on home screen
    And I enter <lname> into lastname text fields on home screen
    And I enter 888888 into mobile number text fields on home screen
    And I enter test1234 into new password text fields on home screen
    And I select Mar from the month drop down menu for birthday
    And I select 20 from the day drop down menu for birthday
    And I select 1990 from the year drop down menu for birthday
    And I click on create account button on home screen
    Then I verify invalid gender error message
    Examples:
      |fname    |lname    |
      |mohammad |muntakim |
      |Nazmul   |Khan     |

  @signup-radio
  Scenario: verify radio button selection
    When I verify male radio button is already Selected
    And I select male radio button
    Then I verify male radio button is selected

