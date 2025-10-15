package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.base.BasePage;

import java.time.Duration;


public class LoginPage extends BasePage {

    private final By signupTitle = By.xpath("//div[@class ='signup-form']/h2");
    private final By nameField = By.cssSelector("input[data-qa='signup-name']");
    private final By emailSignupField = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");
    //private final By submitButton = By.className("btn-default");
    //private final By submitButton = By.xpath("//button[@data-qa='signup-button']");

    private final By loginTitle = By.xpath("//div[@class ='login-form']/h2");
    private final By emailLoginField = By.cssSelector("input[data-qa='login-email']");
    private final By passwordField = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");

    private final By emailPasswordIncorrectMessage = By.xpath("//div[@class='login-form']//p[contains(text(), 'Your email or password is incorrect')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String signupTitle() {
        return driver.findElement(signupTitle).getText();
    }

    public String loginTitle() {
        return driver.findElement(loginTitle).getText();
    }

    public String incorrectLoginMessage() {
        return driver.findElement(emailPasswordIncorrectMessage).getText();
    }


    public HomePage login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailLoginField));

        driver.findElement(emailLoginField).sendKeys(email);
        System.out.println("Email entered: " + email);

        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(password);
        System.out.println("Password entered: " + passwordFieldElement.getAttribute("value"));

        driver.findElement(loginButton).click();
        System.out.println("Form submitted");

        return new HomePage(driver);
    }

    public SignupPage initRegister(String name, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));

        driver.findElement(nameField).sendKeys(name);
        System.out.println("Name entered: " + name);

        driver.findElement(emailSignupField).sendKeys(email);
        System.out.println("Email entered: " + email);

        driver.findElement(signupButton).click();
        System.out.println("Form submitted");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter Account Information']")));

        return new SignupPage(driver);
    }

    public SignupPage alreadyExistInitRegister(String name, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));

        driver.findElement(nameField).sendKeys(name);
        System.out.println("Name entered: " + name);

        driver.findElement(emailSignupField).sendKeys(email);
        System.out.println("Email entered: " + email);

        driver.findElement(signupButton).click();
        System.out.println("Form submitted");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New User Signup!']")));

        return new SignupPage(driver);
    }

}
