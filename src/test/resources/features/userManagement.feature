@userManagement @regression
Feature: Crater User Management
  User management focuses on user creation, update, delete, and authentication.

  @validLoginTest @loginTest @smokeTest
  Scenario: User is able to login successfully
    Given user is on the login page
    When user enters valid "mtlgunduz@gmail.com" and "Password1234"
    And user clicks on login button
    Then user should be navigated to the dashboard page
    And user quits the browser

  @invalidTestSets @loginTest
  Scenario Outline: Invalid login attempts
    Given user is on the login page
    When user enters invalid useremail "<useremail>" and password "<password>"
    And user clicks on login button
    Then error messages appear
    And user is not logged in
    And user quits the browser

    Examples: 
      | useremail         | password      |
      | invalid@imail.com | Password1234  |
      | invalid@imail.com | wrongpassword |
      | mutlu@email.com   | wrongpassword |
      | mutlu@email.com   |               |
      |                   | Password1234  |

  @CreateItemTest
  Scenario: user is able to create an item or service
    Given user is on the login page
    And user navigates to Items tab
    When user clicks on the Add Item button
    And user should be on item input page
    When user provides item information “name” and “price” and “unit” and “description”
    And click Save Item button
    Then the Item is added to the Item list table

  Scenario: user is able to update an item or service
    Given user is on the login page
    And user navigates to Items tab
    When selects the item “Books”
    And user should be on item details page
    When user updates the item price to 30 dollars
    And click Update Item button
    Then the Item price is updated to 30 dollars
