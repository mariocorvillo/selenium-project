package org.selenium.automation.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.models.Product;
import org.selenium.automation.pages.CartPage;
import org.selenium.automation.pages.HomePage;
import org.selenium.automation.pages.LoginPage;
import org.selenium.automation.pages.ProductsPage;
import org.selenium.automation.tests.base.BaseTest;


import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ProductsPageTest extends BaseTest {

    @Test
    public void testAllProductsIsVisible() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        ProductsPage productsPage = homePage.goToProductsCard();

        String actualTitle = productsPage.allProductsTitle();
        String expectedTitle = "ALL PRODUCTS";

        System.out.println("The title of products is: " + actualTitle);
        assertEquals("The title of products is wrong", expectedTitle, actualTitle);
    }

    @Test
    void testGetProductById() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";
        int testId = 8;
        //int testId = 9;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        ProductsPage productsPage = homePage.goToProductsCard();


        Product product = productsPage.getProductById(testId);

        if (productsPage.existsIdProduct(testId)) {
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
        }
        else{
            System.out.println("The product does not exist");
        }
    }

    @Test
    public void testAddProductsToCart() {
        LoginPage loginPage = home.goToLoginCard();

        String testUsername = "testname";
        String testEmail = testUsername + "@example.com";
        String testPassword = "password1";
        //int testIdProduct = 8;
        int testIdProduct = 9;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-qa='login-email']")));

        HomePage homePage = loginPage.login(testEmail,testPassword);
        ProductsPage productsPage = homePage.goToProductsCard();

        boolean expected = productsPage.existsIdProduct(testIdProduct);

        productsPage.addProductsToCart(testIdProduct);
        CartPage cartPage = productsPage.viewCartLink();

        boolean actual = cartPage.isProductInCart(testIdProduct);

        assertEquals("The product with this ID should appear in the cart only if it exists in the products list", expected, actual);
    }

}
