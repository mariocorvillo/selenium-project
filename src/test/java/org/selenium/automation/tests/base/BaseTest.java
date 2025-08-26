package org.selenium.automation.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.automation.pages.HomePage;


public class BaseTest {

    protected WebDriver driver;
    protected HomePage home;

    @BeforeEach
    public void setUpPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com");
        home = new HomePage(driver);
        home.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
