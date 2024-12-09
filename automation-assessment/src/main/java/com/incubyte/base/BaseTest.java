package com.incubyte.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.incubyte.models.User;

public class BaseTest {
    protected static WebDriver driver;
    
    protected User user = new User("testuserFirstName",
            "testuserLastName",
            "testuser.firstname.lastname123@incubyte.com",
            "user@firstname@incubyte!O");

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
