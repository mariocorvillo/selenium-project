package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.base.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By emptyCartTitle = By.xpath("//b[contains(normalize-space(.),'Cart is empty!')]");


    public CartPage (WebDriver driver){
        super(driver);
    }

    public boolean isEmptyCart() {
        List<WebElement> emptyMessage = driver.findElements(emptyCartTitle);

        return !emptyMessage.isEmpty();
    }

    public String emptyCartTitle() {
        List<WebElement> emptyMessage = driver.findElements(emptyCartTitle);

        if (!emptyMessage.isEmpty()) {
            return emptyMessage.get(0).getText().trim();
        } else {
            return "The cart is not empty";
        }
    }

    public boolean isProductInCart(int productId) {
        List<WebElement> product = driver.findElements(By.cssSelector("tr#product-" + productId));

        return !product.isEmpty();
    }


    public CartPage deleteProductInCart(int productId){
        if(isProductInCart(productId)){
            WebElement deleteButton = driver.findElement(By.cssSelector("a.cart_quantity_delete[data-product-id='" + productId + "']"));
            deleteButton.click();
        }
        return new CartPage(driver);
    }

    public CartPage deleteAllProductsInCart(){
        if(!isEmptyCart()){
            List<WebElement> deleteButtons = new ArrayList<>(driver.findElements(By.cssSelector("a.cart_quantity_delete")));
            for(WebElement button : deleteButtons){
                    button.click();
                new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.stalenessOf(button));
            }
        }
        return new CartPage(driver);
    }

}
