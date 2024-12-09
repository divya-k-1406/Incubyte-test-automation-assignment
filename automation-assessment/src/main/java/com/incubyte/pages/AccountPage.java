package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;

    private String myAccountHeaderTitleXpath = "//*[contains(@class, 'page-title')]//*[contains(text(), 'My Account')]";
    private By myAccountHeaderTitle = By.xpath(myAccountHeaderTitleXpath);

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isMyAccountTitleDisplayed() {
        WebElement myAmyAccountHeaderTitleElement = driver.findElement(myAccountHeaderTitle);
        return myAmyAccountHeaderTitleElement.isDisplayed();
    }

    public boolean isCorrectAccountLoggedIn(String firstName, String lastName) {
        String loggedInUserNameXpath = "//*[contains(text(), 'Welcome, " + firstName + " " + lastName +"!')]";
        WebElement loggedInUserNameElement = driver.findElement(By.xpath(loggedInUserNameXpath));
        return loggedInUserNameElement.isDisplayed();
    }
}
