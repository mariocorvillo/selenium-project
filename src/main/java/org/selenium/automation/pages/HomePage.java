package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.automation.base.BasePage;


public class HomePage extends BasePage {

    private final By usernameElement = By.xpath("//a[contains(text(),'Logged in as')]");

    private final By acceptCookiesButton = By.className("fc-button-label");
    private final By productsButton = By.xpath("//li/a[text()=' Products']");
    private final By loginSignupButton = By.xpath("//li/a[text()=' Signup / Login']");
    private final By deleteAccountButton = By.xpath("//li/a[text()=' Delete Account']");
    private final By logoutButton = By.xpath("//li/a[text()=' Logout']");
    private final By cartButton = By.xpath("//li/a[text()=' Cart']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        acceptCookiesIfPresent(acceptCookiesButton);
    }

    public LoginPage goToLoginCard() {
        driver.findElement(loginSignupButton).click();
        return new LoginPage(driver);
    }

    public WebElement getLoggedInAsElement() {
        return driver.findElement(usernameElement);
    }

    public WebElement getLoggedUsername() {
        return driver.findElement(By.xpath("//a/b"));
    }

    public WebElement getDeleteAccountElement() {
        return driver.findElement(deleteAccountButton);
    }

    public DeleteAccountPage goToDeleteAccountCard() {
        driver.findElement(deleteAccountButton).click();
        return new DeleteAccountPage(driver);
    }

    public ProductsPage goToProductsCard() {
        driver.findElement(productsButton).click();
        return new ProductsPage(driver);
    }

    public CartPage goToCartCard() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public LoginPage logout(){
        driver.findElement(logoutButton).click();
        System.out.println("The user has logged out");

        return new LoginPage(driver);
    }
}
