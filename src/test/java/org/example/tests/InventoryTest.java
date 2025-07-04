package org.example.tests;

import org.example.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {


    @Test
    public void testAddProductToCartAndValidatePrice(){



        // 1 login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // 2  add product
        InventoryPage inventoryPage = new InventoryPage(driver);
        String expectedProductName = inventoryPage.getFirstProductName();
        String expectedProductPrice = inventoryPage.getFirstProductPrice();

        inventoryPage.addToCartFirstProduct();
        inventoryPage.goToCart();


        CartPage cartPage = new CartPage(driver);
        String actualProductName = cartPage.getCartProductName();
        String actualProductPrice = cartPage.getCartProductPrice();


        //Assertions
        inventoryPage.assertEquals(expectedProductName, actualProductName);
        inventoryPage.assertEquals(expectedProductPrice, actualProductPrice);


    }





    @Test
    public void checkScrollAndZoom() throws InterruptedException {



        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0, 500);");
        js.executeScript("window.scrollBy(0, 500);");


        Thread.sleep(3000);
        js.executeScript("window.scrollBy(700, 0);");
        Thread.sleep(3000);


        js.executeScript("document.body.style.zoom='150%'");

        Thread.sleep(3000);

        js.executeScript("document.body.style.zoom='70%'");
        Thread.sleep(3000);
        js.executeScript("document.body.style.zoom='100%'");
        Thread.sleep(3000);
   }

}
