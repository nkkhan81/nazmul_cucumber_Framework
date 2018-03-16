@regression @signup
Feature: Verify Signup Feature

  Background:
    Given I am on home page of Amazon

  @amazon-login
  Scenario: Verify user should not be able to login using invalid credentials
    When I Hover over to Accounts & List
    And I click on Sign in button
    And I enter testemaidotcom into email address field
    And I click on continue button
    Then I verify invalid error message
#  Note: Error Message = "There was a problem We cannot find an account with that email address"