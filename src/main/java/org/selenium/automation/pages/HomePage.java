package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.automation.base.BasePage;


public class HomePage extends BasePage {

    private final By acceptCookiesButton = By.className("fc-button-label");
    private final By LoginSignupButton = By.xpath("//li/a[text()=' Signup / Login']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        acceptCookiesIfPresent(acceptCookiesButton);
    }

    public LoginPage goToLoginCard() {
        driver.findElement(LoginSignupButton).click();
        return new LoginPage(driver);
    }

}
