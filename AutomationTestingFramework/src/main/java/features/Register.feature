Feature: Register feature

  Description: This feature is aimed to describe the registration feature behavior

  Background:
    Given "HomePage" is opened

  Scenario: Register button is displayed on Home Page
    When "myAccountButton" button is clicked
    Then "registerButton" is displayed

  Scenario: Register page is accessible from Home Page
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then the new url contains the following string "register"

  @run
  Scenario Outline: Register page url contains the following word <keyword>
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then "RegisterPage" is opened
    And the new url contains the following string "<keyword>"
    Examples:
      | keyword          |
      | index            |
      | account/register |

#  @fieldValidation @run
#  Scenario Outline: Error message is displayed when using invalid <email> email value
#    When "myAccountButton" button is clicked
#    And "registerButton" button is clicked
#    Then "RegisterPage" is opened
#    And the new url contains the following string "register"
#    When the registration form is populated with below data:
#      | firstName | George   |
#      | lastName  | Bush     |
#      | email     | <email>  |
#      | password  | password |
#    And "privacyCheckBox" button is clicked
#    And "continueButton" button is clicked
#    Then the following errors are displayed on the screen:
#      | <error>                                                                           |
#      | Warning: Please include an '@' in the email address. '<email>' is missing an '@'. |
#    Examples:
#      | email      | error                                                                    |
#      | @gmail.com | Please include an '@' in the email address. '<email>' is missing an '@'. |