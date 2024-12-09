package com.incubyte.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.incubyte.base.BaseTest;
import com.incubyte.models.User;
import com.incubyte.pages.AccountPage;
import com.incubyte.pages.HomePage;
import com.incubyte.pages.SignInPage;
import com.incubyte.pages.SignupPage;
import com.incubyte.utils.ScrollActions;

public class CreateNewAccount extends BaseTest {

    
    private User user = new User("usertestFirst",
    "usertestLast",
    "usertest.firstname.1e@incubyte.com",
    "user@firstname@incubyte!O");

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
        signupPage.enterFirstName(user.getFirstName());
        signupPage.enterLastName(user.getLastName());
        signupPage.enterEmailAddress(user.getEmailAddress());
        signupPage.enterPassword(user.getPassword());
        signupPage.confirmPassword(user.getPassword());
        ScrollActions scrollActions = new ScrollActions(driver);
        scrollActions.scrollDown();
        signupPage.clickSubmit();
    }

    @When("the user is taken to the Account page on creating new account")
    public void userRedirectedtoAccountPage() {
        AccountPage accountPage = new AccountPage(driver);
        if(accountPage.isMyAccountTitleDisplayed()) {
            System.out.println("Account page is displayed!");
        } else {
            System.err.println("Account page is not displayed!");
        }
    }

    @Then("the user entered details and the account details are to be same and hence the account creation is successful")
    public void userAccountCreationDetailsVerification() throws InterruptedException {
        AccountPage accountPage = new AccountPage(driver);
        if(accountPage.isMyAccountTitleDisplayed()) {
            //We are introducing a wait here as the web page takes couple of seconds to render the account name
            Thread.sleep(2000);
            ScrollActions scrollActions = new ScrollActions(driver);
            scrollActions.scrollUp();
            accountPage.isCorrectAccountLoggedIn(user.getFirstName(), user.getLastName());
        } else {
            System.err.println("Account page is not displayed!");
        }
        tearDown();
    }
}
