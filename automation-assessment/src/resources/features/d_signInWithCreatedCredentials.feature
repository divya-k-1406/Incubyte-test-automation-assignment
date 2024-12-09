Feature: Redirected to sign in page and signed in with credentials
  As a user
  I need to sign in with the created
  account's credentials.
  Scenario: Redirected to sign in page and signed in with credentials
    Given the user is at home page waiting to get signed in with credentials
    When the user clicks on sign in link and redirected for login
    When the user enters the wrong email and password , error is thrown
    When the user enters the correct email and password and signs in successfully
    Then the user entered details and the account details are to be same and hence the sign in is successful