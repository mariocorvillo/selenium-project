package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.automation.base.BasePage;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedTitle = By.xpath("//*[text()='Account Created!']");
    private final By continueButton = By.className("btn-primary");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String createdAccountTitle() {
        return driver.findElement(accountCreatedTitle).getText();
    }

    public void pressCreateContinueButton() {
        scrollToElementJS(continueButton);
        driver.findElement(continueButton).click();
    }

    public HomePage createdAccount() {
        pressCreateContinueButton();
        return new HomePage(driver);
    }
}
