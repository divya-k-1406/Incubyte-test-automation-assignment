Feature: Redirected to signup page successfully and user creates an account

  Scenario: Redirected to signup page successfully and user creates an account
    Given the user is at home page waiting to get a new account created
    When the user clicks on sign in link and is redirected to sign in page
    When the user clicks on Create an Account button and is redirected to sign up page
    When the user enters all the required fields in the sign up page to create an account
    When the user is taken to the Account page on creating new account
    Then the user entered details and the account details are to be same and hence the account creation is successful