package com.incubyte.stepDefinitions;

import com.incubyte.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class SignupSteps extends BaseTest {

    @Given("the user is on the home page")
    public void userIsOnSignupPage() {
        setUp();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("the user identifies home page content")
    public void userProvidesValidSignupDetails() {
        
    }

    @Then("the site launch is successful")
    public void userShouldSeeAccountConfirmation() {
        if (driver.getPageSource().contains("abc")) {
            System.out.println("Page is loaded successfully");
        } else {
            System.err.println("Page loading failed!");
        }
        tearDown();
    }
}
