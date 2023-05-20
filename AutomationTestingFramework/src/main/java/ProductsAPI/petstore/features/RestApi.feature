@api
Feature: Validate the USER entity

  Background:
    Given user sends a "POST" request to "USER" endpoint with following data object
      | id         | 1234567890000    |
      | username   | viocel           |
      | firstName  | Viorel           |
      | lastName   | Celpan           |
      | email      | viorel@gmail.com |
      | password   | pass             |
      | phone      | 79448040         |
      | userStatus | 0                |
    And the response code is "200"
    And the response contains "unknown"

    Scenario: Get user data
      Given user sends a "GET" request to "USER_USERNAME" endpoint with "viocel" value for "username" path variable
      And the response code is "200"
      And the response contains "unknown"

