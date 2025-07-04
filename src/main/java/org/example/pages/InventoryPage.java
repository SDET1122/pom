package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    WebElement inventoryHeaderText;

    @FindBy (xpath = "(//div[@class='inventory_item'])[1]//div[@class='inventory_item_name ']")
    WebElement firstProductName;

    @FindBy (xpath = "(//div[@class='inventory_item'])[1]//div[@class='inventory_item_price']")
    WebElement firstProductPrice;

    @FindBy (xpath = "(//div[@class='inventory_item'])[1]//button[text() = 'Add to cart']")
    WebElement firstProductAddToCart;


    @FindBy (id = "shopping_cart_container")
    WebElement cartIcon;



    public String getInventoryHeaderText() {
        return getTextFromElement(inventoryHeaderText);
    }



    public String getFirstProductName() {
        return getTextFromElement(firstProductName);
    }


    public String getFirstProductPrice() {
        return getTextFromElement(firstProductPrice);
    }

    public void addToCartFirstProduct(){
        clickToElement(firstProductAddToCart);
    }

    public void goToCart() {
        clickToElement(cartIcon);
    }




}
