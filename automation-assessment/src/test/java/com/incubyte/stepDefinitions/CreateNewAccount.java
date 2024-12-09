package com.incubyte.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.incubyte.base.BaseTest;
import com.incubyte.models.User;
import com.incubyte.pages.HomePage;
import com.incubyte.pages.SignInPage;
import com.incubyte.pages.SignupPage;

public class CreateNewAccount extends BaseTest {

    @Given("the user is at home page waiting to get a new account created")
    public void userIsOnHomePage() {
        setUp();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("the user clicks on sign in link and is redirected to sign in page")
    public void userClicksOnSignInLink() {
        HomePage homePage = new HomePage(driver);
        if (homePage.isSigninLinkPresent()) {
            homePage.clickSigninLink();
        } else {
            System.err.println("Sign in Link is not present!");
        }
    }

    @When("the user clicks on Create an Account button and is redirected to sign up page")
    public void userClicksOnCreateAnAccountLink() {
        SignInPage signInPage = new SignInPage(driver);
        if (signInPage.isCreateAccountButtonPresent()) {
            signInPage.clickCreateAccountButton();
        } else {
            System.err.println("Create an Account button is not present!");
        }
    }

    @When("the user enters all the required fields in the sign up page to create an account")
    public void userEntersSignupDetails() throws InterruptedException {
        SignupPage signupPage = new SignupPage(driver);
        User user = new User("UserFirstName123",
                "UserLastName123",
                "usertest.firstname.1@incubyte.com",
                "user@firstname@incubyte!O");
        signupPage.enterFirstName(user.getFirstName());
        signupPage.enterLastName(user.getLastName());
        signupPage.enterEmailAddress(user.getEmailAddress());
        signupPage.enterPassword(user.getPassword());
        signupPage.confirmPassword(user.getPassword());
        signupPage.clickSubmit();
    }

    @When("the user is taken to the Account page on creating new account")
    public void userRedirectedtoAccountPage() {
        System.out.println("Yet to develop");
    }

    @Then("the user entered details and the account details are to be same and hence the account creation is successful")
    public void userAccountCreationDetailsVerification() {
        System.out.println("Yet to develop");
        tearDown();
    }
}
