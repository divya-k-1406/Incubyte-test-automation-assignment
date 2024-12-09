package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    String CustomerLoginHeaderXpath = "//*[@id='maincontent']//*[contains(text(),'Customer Login')]";
    private By CustomerLoginHeader = By.xpath(CustomerLoginHeaderXpath);

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCustomerLoginHeaderDisplayed() {
        WebElement CustomerLoginHeaderElement = driver.findElement(CustomerLoginHeader);
        return CustomerLoginHeaderElement.isDisplayed();
    }

}
