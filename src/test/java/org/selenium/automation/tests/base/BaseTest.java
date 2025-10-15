package org.selenium.automation.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selenium.automation.pages.HomePage;

import java.util.HashMap;
import java.util.Map;


public class BaseTest {

    protected WebDriver driver;
    protected HomePage home;

    @BeforeEach
    public void setUpPage() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
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
