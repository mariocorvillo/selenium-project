package org.selenium.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.automation.base.BasePage;
import org.selenium.automation.models.Product;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ProductsPage extends BasePage {

    private final By productsTitle = By.xpath("(//h2[@class='title text-center'])");
    private final By continueShoppingButton = By.cssSelector(".btn-success.close-modal.btn-block");
    private final By viewCart = By.cssSelector("a[href='/view_cart']");

    public ProductsPage (WebDriver driver){
        super(driver);
    }

    private By addToCartButtonById(int productId) {
        return By.cssSelector("a[data-product-id='" + productId + "']");
    }


    public String allProductsTitle() {
        scrollToElementJS(productsTitle);
        return driver.findElement(productsTitle).getText();
    }

    public boolean existsIdProduct(int productId) {
        List<Integer> allIds = getAllProductIds();
        return allIds.contains(productId);
    }

    public List<Product> getListProducts() {
        List<WebElement> productCards = driver.findElements(By.cssSelector(".product-image-wrapper"));
        List<Product> products = new ArrayList<>();

        for (WebElement card : productCards) {
            String name = card.findElement(By.cssSelector(".productinfo p")).getText();
            String price = card.findElement(By.cssSelector(".productinfo h2")).getText();

            WebElement addButton = card.findElement(By.cssSelector(".productinfo .add-to-cart"));
            int id = Integer.parseInt(addButton.getAttribute("data-product-id"));

            products.add(new Product(id, name, price));
        }

        return products;
    }

    public Product getProductById(int id) {
        List<Product> products = getListProducts();

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public List<Integer> getAllProductIds() {
        List<Product> products = getListProducts();
        List<Integer> ids = new ArrayList<>();

        for (Product p : products) {
            ids.add(p.getId());
        }

        return ids;
    }

    public void continueShoppingButton(){
        scrollToElementJS(continueShoppingButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }


    public ProductsPage addProductsToCart(int productId) {
        if (!existsIdProduct(productId)) {
            System.out.println("The product with ID " + productId + " does not exist. Cannot be added to cart");
            return this;
        }

        scrollToElementJS(addToCartButtonById(productId));
        driver.findElement(addToCartButtonById(productId)).click();
        continueShoppingButton();
        System.out.println("Product with ID "+ productId + " added to the cart");
        
        return new ProductsPage(driver);
    }

    public CartPage viewCartLink(){
        scrollToElementJS(viewCart);
        driver.findElement(viewCart).click();
        return new CartPage(driver);
    }

}
