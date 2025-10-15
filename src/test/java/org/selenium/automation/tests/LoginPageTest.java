package org.selenium.automation.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.pages.HomePage;
import org.selenium.automation.pages.LoginPage;
import org.selenium.automation.pages.SignupPage;
import org.selenium.automation.tests.base.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest extends BaseTest {

    @Test
    public void testSignupTitleIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String actualTitle = loginPage.signupTitle();
        String expectedTitle = "New User Signup!";

        System.out.println("The title of the signup page is: " + actualTitle);
        Assert.assertEquals("The title of signup page is wrong", expectedTitle, actualTitle);
    }

    @Test
    public void testLoginTitleIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String actualTitle = loginPage.loginTitle();
        String expectedTitle = "Login to your account";

        System.out.println("The title of the login page is: " + actualTitle);
        Assert.assertEquals("The title of login page is wrong", expectedTitle, actualTitle);
    }

    @Test
    public void testLoggedInAsUsernameIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);

        WebElement loggedInAsMessage = homePage.getLoggedInAsElement();

        Assert.assertTrue("'Logged in as username' is not visible", loggedInAsMessage.isDisplayed());
        Assert.assertEquals("Logged in as " + testUsername, loggedInAsMessage.getText());

    }

    @Test
    public void testIncorrectLoginMessageIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password2";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        loginPage.login(testEmail,testPassword);
        String actualTitle = loginPage.incorrectLoginMessage();
        String expectedTitle = "Your email or password is incorrect!";

        System.out.println("The message of incorrect login is: " + actualTitle);
        Assert.assertEquals("Login is wrong", expectedTitle, actualTitle);

    }

    @Test
    public void testAlreadyExistEmailIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-name']")));

        SignupPage signupPage = loginPage.alreadyExistInitRegister(testName,testEmail);

        String actualTitle = signupPage.alreadyExistsMessage();
        String expectedTitle = "Email Address already exist!";

        System.out.println("The message of already email exist is: " + actualTitle);

        Assert.assertEquals("Email address already exist", expectedTitle, actualTitle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New User Signup!']")));
    }

    @Test
    public void testLoggedUsernameIsCorrect() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);

        WebElement username = homePage.getLoggedUsername();

        String actualUsername = username.getText();
        String expectedUsername = "testname";

        System.out.println("The username is: " + actualUsername);
        Assert.assertEquals("The logged username is not correct",
                expectedUsername, actualUsername);
    }

    @Test
    public void testInitRegister() {
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='signup-name']")));

        SignupPage resultPage = loginPage.initRegister(testName,testEmail);

        assertNotNull(resultPage, "Signup page should load");

        System.out.println("Test completed successfully");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Address Information']")));
    }


    @Test
    public void testLogin() {
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage resultPage = loginPage.login(testEmail,testPassword);

        assertNotNull(resultPage, "Login page should load");

        System.out.println("Test completed successfully");

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Logged in as')]")));

    }

    @Test
    public void testLogout() {
        LoginPage loginPage = home.goToLoginCard();

        String testName = "testname";
        String testEmail = testName + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        LoginPage resultPage = homePage.logout();

        assertNotNull(resultPage, "Login page should load");

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login to your account')]")));

    }

}
