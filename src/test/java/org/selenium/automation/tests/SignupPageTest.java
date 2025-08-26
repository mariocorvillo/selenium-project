package org.selenium.automation.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.pages.LoginPage;
import org.selenium.automation.pages.SignupPage;
import org.selenium.automation.tests.base.BaseTest;

import java.time.Duration;


public class SignupPageTest extends BaseTest {

    @Test
    public void testFillAccountInformation(){
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-name']")));

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);
        signupPage.fillAccountInformation();

        System.out.println("Account Information Filled Successfully");

        By signupHeader = By.xpath("//*[text()='Address Information']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupHeader));
    }

}
