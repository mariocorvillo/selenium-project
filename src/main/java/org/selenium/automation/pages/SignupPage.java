package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.automation.base.BasePage;


public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void fillAccountInformation(){
        By radioButton = By.id("id_gender1");
        scrollToElementJS(radioButton);
        click(radioButton);
        System.out.println("RadioButton Pressed");
    }

}
