package com.crowdar.examples.pages;

import com.crowdar.core.pageObjects.PageBaseWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageBaseTravels extends PageBaseWeb {

    public PageBaseTravels(RemoteWebDriver driver) {
        super(driver);
        BASE_URL = "http://phptravels.net/";
    }

    public void waitForElementToBeClickeable(By locator) {
        this.getFluentWait().until(ExpectedConditions.elementToBeClickable(locator));
    }
}
