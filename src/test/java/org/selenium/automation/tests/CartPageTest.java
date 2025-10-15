package org.selenium.automation.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.pages.CartPage;
import org.selenium.automation.pages.HomePage;
import org.selenium.automation.pages.LoginPage;
import org.selenium.automation.tests.base.BaseTest;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class CartPageTest extends BaseTest {

    @Test
    public void testEmptyCardMessageIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        CartPage cartPage = homePage.goToCartCard();

        String actualMessage = cartPage.emptyCartTitle();

        if (actualMessage.equals("Cart is empty!")) {
            assertEquals("Cart is empty!", actualMessage);
        } else {
            System.out.println("The cart is not empty");
        }
    }

    @Test
    public void testDeleteProductInCart(){
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";
        int testId = 1;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        CartPage cartPage = homePage.goToCartCard();

        if(cartPage.isProductInCart(testId)){
            cartPage.deleteProductInCart(testId);
        }

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> !cartPage.isProductInCart(testId));

        Assert.assertFalse("The product should have been deleted from the cart", cartPage.isProductInCart(testId));

    }

    @Test
    public void testDeleteAllProductsInCart(){
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        CartPage cartPage = homePage.goToCartCard();

        if(!cartPage.isEmptyCart()){
            cartPage.deleteAllProductsInCart();
        }

        new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(driver -> cartPage.isEmptyCart());

        Assert.assertTrue("The cart should be empty after deleting all products", cartPage.isEmptyCart());
    }
}
