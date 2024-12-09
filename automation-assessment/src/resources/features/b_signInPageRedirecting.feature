Feature: Redirected to sign in page successfully

  Scenario: User is redirected to Sign in page successfully
    Given the user is on the home page waiting to redirect to sign in page
    When the user identifies the Sign in link
    When the user clicks on the Sign in link
    Then the user has been redirected to the Sign in page
