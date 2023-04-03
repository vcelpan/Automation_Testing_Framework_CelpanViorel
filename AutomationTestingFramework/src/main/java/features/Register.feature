Feature: This feature file is aimed to test the registration flow

  Scenario: Register button is displayed on Home Page
    Given "https://demo.opencart.com/" is accessed
    When my account button is clicked
    Then register account button is displayed

  Scenario: Register page is accessible from Home Page
    Given "https://demo.opencart.com/" is accessed
    When my account button is clicked
    And register account button is clicked
    Then the new url contains the following string "register"