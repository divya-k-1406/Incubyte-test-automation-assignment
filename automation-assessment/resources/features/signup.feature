Feature: Sign Up Process

  Scenario: User signs up successfully
    Given the user is on the signup page
    When the user provides valid signup details
    Then the user should see the account created confirmation
