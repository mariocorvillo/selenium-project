package org.selenium.automation.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class HomePageTest extends BaseTest {

    @Test
    public void testTitleIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Website for automation practice']")));

        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();

        System.out.println("The title of the page is: " + actualTitle);
        Assert.assertEquals("The title does not match", expectedTitle, actualTitle);
    }
}
