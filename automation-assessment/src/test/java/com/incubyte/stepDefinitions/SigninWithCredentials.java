package com.incubyte.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.incubyte.base.BaseTest;
import com.incubyte.pages.HomePage;
import com.incubyte.pages.SignInPage;
import com.incubyte.utils.ScrollActions;

public class SigninWithCredentials extends BaseTest {

    @Given("the user is at home page waiting to get signed in with credentials")
    public void userIsOnHomePage() {
        setUp();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("the user clicks on sign in link and redirected for login")
    public void userClicksOnSignInLink() {
        HomePage homePage = new HomePage(driver);
        if (homePage.isSigninLinkPresent()) {
            homePage.clickSigninLink();
        } else {
            System.err.println("Sign in Link is not present!");
        }
    }

    @When("the user enters the wrong email and password , error is thrown")
    public void userClicksOnCreateAnAccountLink() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress("wrong" + user.getEmailAddress());
        signInPage.enterPassword(user.getPassword());
        signInPage.clickLogin();
        // Waiting for the credentials validation API response time period
        Thread.sleep(5000);
        if (signInPage.isIncorrectSigninErrorMessageDisplayed()) {
            System.out.println("Error message is displayed for incorrect credentials");
        }
    }

    @When("the user enters the correct email and password and signs in successfully")
    public void userEntersSignupDetails() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress(user.getEmailAddress());
        signInPage.enterPassword(user.getPassword());
        signInPage.clickLogin();
    }

    @Then("the user entered details and the account details are to be same and hence the sign in is successful")
    public void userAccountCreationDetailsVerification() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        if (homePage.isMainContentDisplayed()) {
            // We are introducing a wait here as the web page takes couple of seconds to
            // render the account name
            Thread.sleep(2000);
            ScrollActions scrollActions = new ScrollActions(driver);
            scrollActions.scrollUp();
            homePage.isCorrectAccountLoggedIn(user.getFirstName(), user.getLastName());
        } else {
            System.err.println("Account page is not displayed!");
        }
        tearDown();
    }
}
