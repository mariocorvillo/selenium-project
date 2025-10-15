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


public class SignupPageTest extends BaseTest {

    @Test
    public void testAccountInformationIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-name']")));

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);

        String actualTitle = signupPage.AccountInformationTitle();
        String expectedTitle = "ENTER ACCOUNT INFORMATION";

        System.out.println("The title of account information is: " + actualTitle);
        Assert.assertEquals("The title of account information is wrong", expectedTitle, actualTitle);
    }

    @Test
    public void testAddressInformationIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-name']")));

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);

        String actualTitle = signupPage.AddressInformationTitle();
        String expectedTitle = "ADDRESS INFORMATION";

        System.out.println("The title of address information is: " + actualTitle);
        Assert.assertEquals("The title of address information is wrong", expectedTitle, actualTitle);
    }

    @Test
    public void testFillAccountInformation(){
        LoginPage loginPage = home.goToLoginCard();

        String testGender = "Mr";
        String testName = "testname";
        String testEmail = testName + "@example.com";
        String testPassword = "password1";
        String testDay = "28";
        String testMonth = "8";
        String testYear = "1992";
        Boolean testNeysletter = true;
        Boolean testOffer = false;


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-name']")));

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);
        signupPage.fillAccountInformation(testGender, testPassword, testDay, testMonth, testYear, testNeysletter, testOffer);

        System.out.println("Account information filled successfully");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Address Information']")));
    }

    @Test
    public void testFillAddressInformation(){
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname3";
        String testEmail = testName + "@example.com";
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By signupName = By.cssSelector("input[data-qa='signup-name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupName));

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);
        signupPage.fillAddressInformation(testFirstName,testLastName, testCompany, testAddress1, testAddress2, testCountry, testState, testCity, testZipcode, testMobileNumber);

        System.out.println("Account address filled successfully");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-qa='create-account']")));
    }
    @Test
    public void testRegister() {
        LoginPage loginPage = home.goToLoginCard();

        String testGender = "Mr";
        String testName = "testname6";
        String testEmail = testName + "@example.com";
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By signupName = By.cssSelector("input[data-qa='signup-name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupName));

        SignupPage signupPage = loginPage.initRegister(testName,testEmail);
        signupPage.register(testGender, testPassword, testDay, testMonth,
                testYear, testNeysletter, testOffer, testFirstName,testLastName, testCompany, testAddress1,
                testAddress2, testCountry, testState, testCity, testZipcode, testMobileNumber);

        System.out.println("Account address filled successfully");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Account Created!']")));
    }


}
