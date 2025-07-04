package org.example;

import org.example.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;




    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void clickToElement(WebElement locator){
        waitForElementToBeClickable(locator);
        locator.click();
        Utils.logInfo("click to element: " + locator);
    }



    public void enterText(WebElement locator, String text){
        waitForElementToBeVisible(locator);
        locator.sendKeys(text);
        Utils.logInfo("sendKey: [ " + text + " ] to element: " + locator);
    }



    public void waitForElementToBeClickable(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Utils.logInfo("waiting " + locator + " if is it clickable");
    }


    public void waitForElementToBeVisible(WebElement locator) {
       wait.until(ExpectedConditions.visibilityOf(locator));
        Utils.logInfo("waiting element: " + locator);
    }


    public void assertEquals(String expectedUrl, String actualUrl) {
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public void assertEquals(String expectedUrl, String actualUrl, String message) {
        Assert.assertEquals(actualUrl, expectedUrl, message);
    }


    public void refreshPage(){
        driver.navigate().refresh();
        Utils.logInfo("refresh page: " + driver.getCurrentUrl());


    }

    public String getCurrentUrl() {
        Utils.logInfo("get current url: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String getTextFromElement(WebElement locator) {
        waitForElementToBeVisible(locator);
        Utils.logInfo("text founded: " + locator.getText());
        return locator.getText();
    }


    public String getCssValue(WebElement locator, String propertyName){
        waitForElementToBeVisible(locator);
        Utils.logInfo("PropertyName is: " + propertyName);
        return locator.getCssValue(propertyName);
    }

}
