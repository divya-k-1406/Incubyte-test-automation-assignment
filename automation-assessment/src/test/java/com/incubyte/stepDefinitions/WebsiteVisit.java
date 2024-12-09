package com.incubyte.stepDefinitions;

import com.incubyte.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebsiteVisit extends BaseTest {

    @Given("the user is on the home page")
    public void userIsOnHomePage() {
        setUp();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("the user identifies contents from the home page")
    public void userIdentifiesHomePageContent() {
        String mainContentXpath = "//*[@id='maincontent']";
        WebElement mainContent = driver.findElement(By.xpath(mainContentXpath));
        System.out.println("tesxt" + mainContent.getText());
        mainContent.click();
    }

    @Then("the user has loaded the page sucessfully")
    public void userLaunchesWebPageSuccessfully() {
        if (driver.getPageSource().contains("abc")) {
            System.out.println("Page is loaded successfully");
        } else {
            System.err.println("Page loading failed!");
        }
        tearDown();
    }
}