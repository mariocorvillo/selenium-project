package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.base.BasePage;

import java.time.Duration;


public class LoginPage extends BasePage {

    private final By signupTitle = By.xpath("//div[@class ='signup-form']/h2");
    private final By nameField = By.cssSelector("input[data-qa='signup-name']");
    private final By emailField = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");
    //private final By submitButton = By.className("btn-default");
    //private final By submitButton = By.xpath("//button[@data-qa='signup-button']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String signupTitle() {
        return driver.findElement(signupTitle).getText();
    }

    public SignupPage initRegister(String name, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));

        driver.findElement(nameField).sendKeys(name);
        System.out.println("Name Entered: " + name);

        driver.findElement(emailField).sendKeys(email);
        System.out.println("Email Entered: " + email);

        driver.findElement(signupButton).click();
        System.out.println("Form Submitted");

        By signupHeader = By.xpath("//*[text()='Enter Account Information']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupHeader));

        return new SignupPage(driver);
    }

}
