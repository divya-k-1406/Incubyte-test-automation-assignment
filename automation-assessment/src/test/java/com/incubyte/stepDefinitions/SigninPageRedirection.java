package com.incubyte.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.incubyte.base.BaseTest;
import com.incubyte.pages.HomePage;
import com.incubyte.pages.SignInPage;

public class SigninPageRedirection extends BaseTest {

    @Given("the user is on the home page waiting to redirect to sign in page")
    public void userIsOnHomePage() {
        setUp();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("the user identifies the Sign in link")
    public void userIdentifiesSigninLink() {
        HomePage homePage = new HomePage(driver);
        if (homePage.isSigninLinkPresent()) {
            System.out.println("Sign in Link is present");
        } else {
            System.err.println("Sign in Link is not present!");
        }
    }

    @When("the user clicks on the Sign in link")
    public void userClicksOnSigninLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSigninLink();
    }

    @Then("the user has been redirected to the Sign in page")
    public void userRedirectedToSigninPageSuccessfully() {
        SignInPage signInPage = new SignInPage(driver);
        if (signInPage.isCustomerLoginHeaderDisplayed()) {
            System.out.println("Sign in Page is loaded successfully");
        } else {
            System.err.println("Sign in Page loading failed!");
        }
        tearDown();
    }
}
