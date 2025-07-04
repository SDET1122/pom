package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import org.example.BasePage;
import org.example.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

//    private By usernameField = By.id("user-name");
//    private By passwordField = By.id("password");
//    private By loginButton = By.id("login-button");



    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;





    public void login(String username, String password) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickToElement(loginButton);
    }

    public String getLoginButtonColor() {
        Utils.logInfo(getCssValue(loginButton, "background-color"));
        return getCssValue(loginButton, "background-color");
    }


}
