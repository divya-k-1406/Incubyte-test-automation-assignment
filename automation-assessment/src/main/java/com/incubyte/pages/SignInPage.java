package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    private String CustomerLoginHeaderXpath = "//*[@id='maincontent']//*[contains(text(),'Customer Login')]";
    private By CustomerLoginHeader = By.xpath(CustomerLoginHeaderXpath);

    private String createAccountButtonXpath = "//*[contains(@class,'actions-toolbar')]//a[contains(@class,'create')]";
    private By createAccountButton = By.xpath(createAccountButtonXpath);

    private String loginEmailFieldXpath = "//*[@id='email']";
    private By loginEmailField = By.xpath(loginEmailFieldXpath);

    private String loginPasswordFieldXpath = "//*[@id='pass']";
    private By loginPasswordField = By.xpath(loginPasswordFieldXpath);

    private String loginButtonXpath = "//*[contains(@class,'actions-toolbar')]//button[contains(@class, 'login') and contains(@class, 'primary')]";
    private By loginButton = By.xpath(loginButtonXpath);

    private String forgotPasswordLinkXpath = "/*[@id=\"login-form\"]//a[contains(@class, 'remind')]//*[contains(text(), 'Forgot Your Password')]";
    private By forgotPasswordLink = By.xpath(forgotPasswordLinkXpath);


    private String incorrectSigninErrorMessageXpath = "//*[contains(text(), 'The account sign-in was incorrect')]";
    private By incorrectSigninErrorMessage = By.xpath(incorrectSigninErrorMessageXpath);
    

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCustomerLoginHeaderDisplayed() {
        WebElement CustomerLoginHeaderElement = driver.findElement(CustomerLoginHeader);
        return CustomerLoginHeaderElement.isDisplayed();
    }

    public boolean isCreateAccountButtonPresent() {
        WebElement createAccountButtonElement = driver.findElement(createAccountButton);
        return createAccountButtonElement.isDisplayed();
    }

    public void clickCreateAccountButton() {
        WebElement createAccountButtonElement = driver.findElement(createAccountButton);
        if (createAccountButtonElement.isDisplayed()) {
            createAccountButtonElement.click();
        } else {
            System.err.println("Create an Account button is not displayed");
        }
    }

    public void enterEmailAddress(String emailAddress) {
        WebElement emailAddressFieldElement = driver.findElement(loginEmailField);
        if (emailAddressFieldElement.isDisplayed()) {
            emailAddressFieldElement.clear();
            emailAddressFieldElement.sendKeys(emailAddress);
        } else {
            System.err.println("Email address field is not displayed");
        }
    }

    public void enterPassword(String password) {
        WebElement passwordFieldElement = driver.findElement(loginPasswordField);
        if (passwordFieldElement.isDisplayed()) {
            passwordFieldElement.clear();
            passwordFieldElement.sendKeys(password);
        } else {
            System.err.println("Password field is not displayed");
        }
    }

    public void clickLogin() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        if (loginButtonElement.isDisplayed()) {
            loginButtonElement.click();
        } else {
            System.err.println("Login is not displayed");
        }
    }

    public void clickForogotPassword() {
        WebElement forgotPasswordLinkElement = driver.findElement(forgotPasswordLink);
        if (forgotPasswordLinkElement.isDisplayed()) {
            forgotPasswordLinkElement.clear();
        } else {
            System.err.println("Forgot password link is not displayed");
        }
    }

    public boolean isIncorrectSigninErrorMessageDisplayed() {
        WebElement incorrectSigninErrorMessageElement = driver.findElement(incorrectSigninErrorMessage);
        return incorrectSigninErrorMessageElement.isDisplayed();
    }

}
