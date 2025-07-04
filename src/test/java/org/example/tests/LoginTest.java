package org.example.tests;

import org.example.BaseTest;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {




    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        loginPage.assertEquals(loginPage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "URL is not correct");
        loginPage.refreshPage();
        loginPage.assertEquals(loginPage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "URL is not correct");
        inventoryPage.assertEquals("Products", inventoryPage.getInventoryHeaderText());
    }

    @Test
    public void testLoginButtonTextColor() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedColor = "rgba(61, 220, 145, 1)";
        String actualColor = loginPage.getLoginButtonColor();
        loginPage.assertEquals(expectedColor, actualColor);

    }



}
