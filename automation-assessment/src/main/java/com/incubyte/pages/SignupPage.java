package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    private WebDriver driver;

    private String createNewCustomerHeaderXpath = "//*[@id='maincontent']//*[contains(text(),'Create New Customer Account')]";
    private By createNewCustomerHeader = By.xpath(createNewCustomerHeaderXpath);

    private String firstNameXpath = "//*[@id='firstname']";
    private By firstNameField = By.xpath(firstNameXpath);

    private String lastNameXpath = "//*[@id='lastname']";
    private By lastNameField = By.xpath(lastNameXpath);

    private String emailAddressXpath = "//*[@id='email_address']";
    private By emailAddressField = By.xpath(emailAddressXpath);

    private String passwordXpath = "//*[@id='password']";
    private By passwordField = By.xpath(passwordXpath);

    private String confirmPasswordXpath = "//*[@id='password-confirmation']";
    private By confirmPasswordField = By.xpath(confirmPasswordXpath);

    private String submitButtonXpath = "//*[@id='form-validate']//button";
    private By submitButton = By.xpath(submitButtonXpath);

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCreateNewCustomerHeaderXpathDisplayed() {
        WebElement CreateNewCustomerHeaderElement = driver.findElement(createNewCustomerHeader);
        return CreateNewCustomerHeaderElement.isDisplayed();
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameFieldElement = driver.findElement(firstNameField);
        if (firstNameFieldElement.isDisplayed()) {
            firstNameFieldElement.sendKeys(firstName);
        } else {
            System.err.println("Firstname field is not displayed");
        }
    }

    public void enterLastName(String lastName) {
        WebElement lastNameFieldElement = driver.findElement(lastNameField);
        if (lastNameFieldElement.isDisplayed()) {
            lastNameFieldElement.sendKeys(lastName);
        } else {
            System.err.println("LastName field is not displayed");
        }
    }

    public void enterEmailAddress(String emailAddress) {
        WebElement emailAddressFieldElement = driver.findElement(emailAddressField);
        if (emailAddressFieldElement.isDisplayed()) {
            emailAddressFieldElement.sendKeys(emailAddress);
        } else {
            System.err.println("Email address field is not displayed");
        }
    }

    public void enterPassword(String password) {
        WebElement passwordFieldElement = driver.findElement(passwordField);
        if (passwordFieldElement.isDisplayed()) {
            passwordFieldElement.sendKeys(password);
        } else {
            System.err.println("Password field is not displayed");
        }
    }

    public void confirmPassword(String confirmPassword) {
        WebElement confirmPasswordFieldElement = driver.findElement(confirmPasswordField);
        if (confirmPasswordFieldElement.isDisplayed()) {
            confirmPasswordFieldElement.sendKeys(confirmPassword);
        } else {
            System.err.println("Password confirmation field is not displayed");
        }
    }

    public void clickSubmit() {
        WebElement submitButtonElement = driver.findElement(submitButton);
        if (submitButtonElement.isDisplayed()) {
            submitButtonElement.click();
        } else {
            System.err.println("Submit button is not displayed");
        }
    }

}
