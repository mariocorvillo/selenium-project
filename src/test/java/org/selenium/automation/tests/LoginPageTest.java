package org.selenium.automation.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.pages.LoginPage;
import org.selenium.automation.pages.SignupPage;
import org.selenium.automation.tests.base.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class LoginPageTest extends BaseTest {

    @Test
    public void testSignupTitle() {
        LoginPage loginPage = home.goToLoginCard();

        String actualTitle = loginPage.signupTitle();
        String expectedTitle = "New User Signup!";

        System.out.println("The Title of The Signup Page Is: " + actualTitle);
        Assert.assertEquals("The Title of Signup Page Is Wrong", expectedTitle, actualTitle);
    }

    @Test
    public void testInitRegister() {
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-name']")));

        SignupPage resultPage = loginPage.initRegister(testName,testEmail);

        assertNotNull(resultPage, "Signup Page Should Load.");

        System.out.println("Test Completed Successfully");

        By signupHeader = By.xpath("//*[text()='Address Information']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupHeader));
    }


}
