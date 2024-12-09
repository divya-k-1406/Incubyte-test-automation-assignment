package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    private String mainContentBannerXpath = "//*[@id='maincontent']";
    private By mainContentBanner = By.xpath(mainContentBannerXpath);

    private String collectionPageTitleHeaderXpath = "//*[@id='maincontent']//*[contains(@class, 'page-title-wrapper')]";
    private By collectionPageTitleHeader = By.xpath(collectionPageTitleHeaderXpath);

    private String signInLinkXpath = "//header//a[contains(text(), 'Sign In')]";
    private By signInLink = By.xpath(signInLinkXpath);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isMainContentDisplayed() {
        WebElement mainContentBannerElement = this.driver.findElement(mainContentBanner);
        return mainContentBannerElement.isDisplayed();
    }

    public void clickMainContent() {
        WebElement mainContentBannerElement = this.driver.findElement(mainContentBanner);
        if (mainContentBannerElement.isDisplayed()) {
            mainContentBannerElement.click();
        } else {
            System.err.println("Main content banner is not displayed");
        }
    }

    public boolean isCollectionPageTitleHeaderDisplayed() {
        WebElement collectionPageTitleHeaderElement = this.driver.findElement(collectionPageTitleHeader);
        return collectionPageTitleHeaderElement.isDisplayed();
    }

    public boolean isSigninLinkPresent() {
        WebElement signInLinkElement = this.driver.findElement(signInLink);
        return signInLinkElement.isDisplayed();
    }

    public void clickSigninLink() {
        WebElement signInLinkElement = this.driver.findElement(signInLink);
        if (signInLinkElement.isDisplayed()) {
            signInLinkElement.click();
        } else {

            System.err.println("Sign in Link is not displayed");
        }
    }

    public boolean isCorrectAccountLoggedIn(String firstName, String lastName) {
        String loggedInUserNameXpath = "//*[contains(text(), 'Welcome, " + firstName + " " + lastName + "!')]";
        WebElement loggedInUserNameElement = driver.findElement(By.xpath(loggedInUserNameXpath));
        return loggedInUserNameElement.isDisplayed();
    }
}
