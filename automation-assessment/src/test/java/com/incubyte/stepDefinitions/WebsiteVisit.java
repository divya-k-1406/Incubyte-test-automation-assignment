package com.incubyte.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.incubyte.base.BaseTest;
import com.incubyte.pages.HomePage;

public class WebsiteVisit extends BaseTest {

    @Given("the user is on the home page")
    public void userIsOnHomePage() {
        setUp();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("the user identifies contents from the home page")
    public void userIdentifiesHomePageContent() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMainContent();
    }

    @Then("the user has loaded the page sucessfully")
    public void userLaunchesWebPageSuccessfully() {
        HomePage homePage = new HomePage(driver);
        if (homePage.isCollectionPageTitleHeaderDisplayed()) {
            System.out.println("Page is loaded successfully");
        } else {
            System.err.println("Page loading failed!");
        }
        tearDown();
    }
}
