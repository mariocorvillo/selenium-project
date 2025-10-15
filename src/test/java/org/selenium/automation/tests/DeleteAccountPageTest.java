package org.selenium.automation.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.pages.DeleteAccountPage;
import org.selenium.automation.pages.HomePage;
import org.selenium.automation.pages.LoginPage;
import org.selenium.automation.tests.base.BaseTest;

import java.time.Duration;


public class DeleteAccountPageTest extends BaseTest {

    @Test
    public void testDeleteAccountIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname2";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);

        String actualElement = homePage.getDeleteAccountElement().getText();
        String expectedElement = "Delete Account";

        System.out.println("The element of the delete account is: " + actualElement);
        Assert.assertEquals("The element is wrong", expectedElement, actualElement);
    }


    @Test
    public void testDeleteAccountTitleIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname2";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        DeleteAccountPage deleteAccountPage = homePage.goToDeleteAccountCard();

        String actualTitle = deleteAccountPage.deletedAccountTitle();
        String expectedTitle = "ACCOUNT DELETED!";

        System.out.println("The title of the delete account is: " + actualTitle);
        Assert.assertEquals("The title of delete account is wrong", expectedTitle, actualTitle);
    }

    @Test
    public void testDeleteAccount() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname5";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        DeleteAccountPage deleteAccountPage = homePage.goToDeleteAccountCard();
        deleteAccountPage.deleteAccount();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Website for automation practice']")));

    }
}
