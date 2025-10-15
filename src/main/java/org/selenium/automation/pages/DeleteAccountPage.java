package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.automation.base.BasePage;

public class DeleteAccountPage extends BasePage {

    private final By continueButton = By.className("btn-primary");
    private final By deleteAccountTitle = By.xpath("//*[text()='Account Deleted!']");

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    public String deletedAccountTitle() {
        return driver.findElement(deleteAccountTitle).getText();
    }

    public void pressDeleteContinueButton() {
        scrollToElementJS(continueButton);
        driver.findElement(continueButton).click();
    }

    public HomePage deleteAccount() {
        pressDeleteContinueButton();
        return new HomePage(driver);
    }
}
