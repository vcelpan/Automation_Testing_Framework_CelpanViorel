Feature: Register feature

  Description: This feature is aimed to describe the registration feature behavior

  Background:
    Given "HomePage" is opened

  @run @test1
  Scenario: Register button is displayed on Home Page
    When "myAccountButton" button is clicked
    Then "registerButton" is displayed

  @run @test2
  Scenario: Register page is accessible from Home Page
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then the new url contains the following string "register"

  @run @test3
  Scenario Outline: Register page url contains the following word <keyword>
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then "RegisterPage" is the new page opened
    And the new url contains the following string "<keyword>"
    Examples:
      | keyword          |
      | index            |
      | account/register |

  @fieldValidation @run @test4
  Scenario Outline: Error message is displayed when using invalid <password> as password value
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then "RegisterPage" is the new page opened
    And the new url contains the following string "register"
    When the registration form is populated with below data:
      | firstName       | George          |
      | lastName        | Bush            |
      | email           | ghita@gmail.com |
      | telephone       | 123456789       |
      | password        | <password>      |
      | passwordConfirm | password        |
    And "privacyCheckBox" button is clicked
    And "continueButton" button is clicked
    Then the following errors are displayed on the screen:
      | <error>                                        |
      | Password confirmation does not match password! |
    Examples:
      | password  | error                                         |
      |           | Password must be between 4 and 20 characters! |
      | 1         | Password must be between 4 and 20 characters! |
      | 12        | Password must be between 4 and 20 characters! |
      | 123       | Password must be between 4 and 20 characters! |
      | password1 |                                               |