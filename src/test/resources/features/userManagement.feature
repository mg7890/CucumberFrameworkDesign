Feature: Crater User Management
  User management focuses on user creation, update, delete, and authentication.

  Scenario: User is able to login successfully
    Given user is on the login page
    When user enters valid username and password
    And user clicks on login button
    Then user should be navigated to the dashboard page
