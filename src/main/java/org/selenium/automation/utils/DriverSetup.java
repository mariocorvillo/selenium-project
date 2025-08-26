package org.selenium.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverSetup {
    private static final String CHROME_DRIVER_PATH = "C:\\tools\\drivers\\chromedriver.exe";

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
