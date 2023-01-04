Feature: Crater User Management
  User management focuses on user creation, update, delete, and authentication.

  @validLoginTest
  Scenario: User is able to login successfully
    Given user is on the login page
    When user enters valid "mtlgunduz@gmail.com" and "Password1234"
    And user clicks on login button
    Then user should be navigated to the dashboard page

  @invalidLoginTest
  Scenario: Invalid login attempts
    Given user is on the login page    #already implemented
    When user enters invalid "invalid@imail.com" and "invalid"
    And user clicks on login button     #already implemented
    Then an error message appears
    And user is not logged in
