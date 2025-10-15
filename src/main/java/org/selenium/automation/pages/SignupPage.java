package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.selenium.automation.base.BasePage;

import java.util.Map;


public class SignupPage extends BasePage {
    private final By accountInformationTitle = By.xpath("(//h2[@class='title text-center'])[1]/b");
    private final Map<String, By> radioMap = Map.of(
            "Mr", By.id("id_gender1"),
            "Mrs", By.id("id_gender2")
    );
    private final By passwordField = By.id("password");
    //private final By passwordField = By.cssSelector("input[data-qa='password']");
    private final By dayField = By.id("days");
    private final By monthField = By.id("months");
    private final By yearField = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By offerCheckbox = By.id("optin");

    private final By addressInformationTitle = By.xpath("(//h2[@class='title text-center'])[2]/b");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryField = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");

    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    private final By emailAlreadyExistsMessage = By.xpath("//div[@class='signup-form']//p[contains(text(), 'Email Address already exist!')]");


    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public String AccountInformationTitle() {
        scrollToElementJS(accountInformationTitle);
        return driver.findElement(accountInformationTitle).getText();
    }

    public String AddressInformationTitle() {
        scrollToElementJS(addressInformationTitle);
        return driver.findElement(addressInformationTitle).getText();
    }

    public String alreadyExistsMessage() {
        return driver.findElement(emailAlreadyExistsMessage).getText();
    }

    public void fillAccountInformation(String gender, String password, String day, String month, String year, Boolean newsletter, Boolean offer) {

        By radioButton = radioMap.get(gender);
        if (radioButton == null) {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
        scrollToElementJS(radioButton);
        click(radioButton);
        System.out.println("RadioButton pressed");

        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(password);
        System.out.println("Password entered: " + passwordFieldElement.getAttribute("value"));

        Select daySelect = new Select(driver.findElement(dayField));
        daySelect.selectByValue(day);

        Select monthSelect = new Select(driver.findElement(monthField));
        monthSelect.selectByValue(month);

        Select yearSelect = new Select(driver.findElement(yearField));
        yearSelect.selectByValue(year);
        System.out.println("Date of birth: " + day + "/" + month + "/" + year);


        WebElement checkbox1 = driver.findElement(newsletterCheckbox);
        scrollToElementJS(offerCheckbox);

        WebElement checkbox2 = driver.findElement(offerCheckbox);
        scrollToElementJS(newsletterCheckbox);


        if (newsletter) {
            if (!checkbox1.isSelected()) {
                click(newsletterCheckbox);
                System.out.println("Checkbox selected");
            }
        } else {
            if (checkbox1.isSelected()) {
                click(newsletterCheckbox);
                System.out.println("Checkbox is not selected");
            }
        }

        if (offer) {
            if (!checkbox2.isSelected()) {
                click(offerCheckbox);
                System.out.println("Checkbox selected");
            }
        } else {
            if (checkbox2.isSelected()) {
                click(offerCheckbox);
                System.out.println("Checkbox is not selected");
            }
        }

    }

    public void fillAddressInformation(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        WebElement firstNameFieldElement = driver.findElement(firstNameField);
        firstNameFieldElement.sendKeys(firstName);
        System.out.println("First name entered: " + firstNameFieldElement.getAttribute("value"));

        WebElement lastNameFieldElement = driver.findElement(lastNameField);
        lastNameFieldElement.sendKeys(lastName);
        System.out.println("Last name entered: " + lastNameFieldElement.getAttribute("value"));

        WebElement companyFieldElement = driver.findElement(companyField);
        companyFieldElement.sendKeys(company);
        System.out.println("Company entered: " + companyFieldElement.getAttribute("value"));

        WebElement address1FieldElement = driver.findElement(address1Field);
        address1FieldElement.sendKeys(address1);
        System.out.println("Address 1 entered: " + address1FieldElement.getAttribute("value"));

        WebElement address2FieldElement = driver.findElement(address2Field);
        address2FieldElement.sendKeys(address2);
        System.out.println("Address 2 entered: " + address2FieldElement.getAttribute("value"));

        Select countrySelect = new Select(driver.findElement(countryField));
        countrySelect.selectByValue(country);
        System.out.println("Country entered: " + country);

        WebElement stateFieldElement = driver.findElement(stateField);
        stateFieldElement.sendKeys(state);
        System.out.println("State entered: " + stateFieldElement.getAttribute("value"));

        WebElement cityFieldElement = driver.findElement(cityField);
        cityFieldElement.sendKeys(city);
        System.out.println("City entered: " + cityFieldElement.getAttribute("value"));

        WebElement zipcodeFieldElement = driver.findElement(zipcodeField);
        zipcodeFieldElement.sendKeys(zipcode);
        System.out.println("Zipcode entered: " + zipcodeFieldElement.getAttribute("value"));

        WebElement mobileNumberFieldElement = driver.findElement(mobileNumberField);
        mobileNumberFieldElement.sendKeys(mobileNumber);
        System.out.println("City entered: " + mobileNumberFieldElement.getAttribute("value"));

    }

    public AccountCreatedPage pressCreateAccountButton() {
        driver.findElement(createAccountButton).click();
        return new AccountCreatedPage(driver);
    }

    public AccountCreatedPage register(String gender, String password, String day, String month,
                                       String year, Boolean newsletter, Boolean offer,
                                       String firstName, String lastName, String company, String address1,
                                       String address2, String country, String state, String city,
                                       String zipcode, String mobileNumber) {

        fillAccountInformation(gender, password, day, month, year, newsletter, offer);
        fillAddressInformation(firstName, lastName, company, address1, address2, country, state, city,
                zipcode,mobileNumber);
        pressCreateAccountButton();
        return new AccountCreatedPage(driver);
    }
}
