package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_item .inventory_item_name")
    WebElement cartProductName;

    @FindBy(css = ".cart_item .inventory_item_price")
    WebElement cartProductPrice;





    public String getCartProductName() {
        return  getTextFromElement(cartProductName);
    }


    public String getCartProductPrice() {
        return  getTextFromElement(cartProductPrice);
    }

}
