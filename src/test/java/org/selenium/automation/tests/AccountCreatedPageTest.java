package org.selenium.automation.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.pages.*;
import org.selenium.automation.tests.base.BaseTest;

import java.time.Duration;

public class AccountCreatedPageTest extends BaseTest {
    @Test
    public void testCreatedAccountTitleIsVisible() {
        LoginPage loginPage = home.goToLoginCard();
        String testName = "testname5";
        String testEmail = testName + "@example.com";

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);

        String testGender = "Mr";
        String testPassword = "password1";
        String testDay = "28";
        String testMonth = "8";
        String testYear = "1992";
        Boolean testNeysletter = true;
        Boolean testOffer = false;
        String testFirstName = "Bryan";
        String testLastName = "Adams";
        String testCompany = "Google";
        String testAddress1 = "250 Princess Street";
        String testAddress2 = "";
        String testCountry = "Canada";
        String testState = "Ontario";
        String testCity = "Kingston";
        String testZipcode = "K7L 1B6";
        String testMobileNumber = "+1 613-555-7890";

        AccountCreatedPage accountCreatedPage = signupPage.register(testGender, testPassword, testDay, testMonth,
                testYear, testNeysletter, testOffer, testFirstName, testLastName, testCompany, testAddress1,
                testAddress2, testCountry, testState, testCity, testZipcode,testMobileNumber);


        String actualTitle = accountCreatedPage.createdAccountTitle();
        String expectedTitle = "ACCOUNT CREATED!";

        System.out.println("The title of the account created page is: " + actualTitle);
        Assert.assertEquals("The title of the account created page is wrong", expectedTitle, actualTitle);
    }

    @Test
    public void testCreatedAccount() {
        LoginPage loginPage = home.goToLoginCard();
        String testName = "testname5";
        String testEmail = testName + "@example.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);

        String testGender = "Mr";
        String testPassword = "password1";
        String testDay = "28";
        String testMonth = "8";
        String testYear = "1992";
        Boolean testNeysletter = true;
        Boolean testOffer = false;
        String testFirstName = "Bryan";
        String testLastName = "Adams";
        String testCompany = "Google";
        String testAddress1 = "250 Princess Street";
        String testAddress2 = "";
        String testCountry = "Canada";
        String testState = "Ontario";
        String testCity = "Kingston";
        String testZipcode = "K7L 1B6";
        String testMobileNumber = "+1 613-555-7890";

        AccountCreatedPage accountCreatedPage = signupPage.register(testGender, testPassword, testDay, testMonth,
                testYear, testNeysletter, testOffer, testFirstName, testLastName, testCompany, testAddress1,
                testAddress2, testCountry, testState, testCity, testZipcode,testMobileNumber);

        accountCreatedPage.createdAccount();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Website for automation practice']")));

    }
}
