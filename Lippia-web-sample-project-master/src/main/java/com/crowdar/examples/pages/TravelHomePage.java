package com.crowdar.examples.pages;

import com.crowdar.core.Injector;
import com.crowdar.examples.Reports.ExtentReportsConfig;
import com.crowdar.examples.Utils.DataSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class TravelHomePage extends PageBaseTravels {

    private final String LINK_ABOUTUS_XPATH = "//*[@id=\"footer\"]/div[1]/div[1]/div[2]/div/div/div[1]/ul/li[1]/ul/li[4]/a";
    private final String LINK_CARS_XPATH = "//a[@href='#cars']";
    private final String BTN_SEARCH_XPATH = "//*[@id=\"cars\"]/div/div/form/div/div/div[5]/button";
    private final String TXT_PICKUP_XPATH = "//div[contains(@class, 'car-startlocation')]/input[contains(@id, 'autogen')]";
    private final String TXT_DROPOFF_XPATH = "//div[contains(@class, 'car-endlocation')]/input[contains(@id, 'autogen')]";
    private final String CAL_DEPARTDATE_NAME = "pickupdate";
    private final String CAL_RETURNDATE_NAME = "dropoffdate";
    private final String DD_DEPARTTIME_XPATH = "//*[@id=\"airDatepickerRange-flight\"]/div[2]/div/div/div/a";
    private final String DD_SELPICKUPSEARCH_XPATH = "//li[contains(@class, 'select2-highlighted')]";
    private final String DD_SELDROPOFFSEARCH_XPATH = "//li[contains(@class, 'select2-highlighted')]";
    private String departTimeXpathWithHour;


    public TravelHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void go() throws IOException {
        navigateToCompleteURL();
    }

    public TravelAboutUsResultPage clickAboutUsLink() throws IOException {
        clickElement(By.xpath(LINK_ABOUTUS_XPATH));
        ExtentReportsConfig.ScreenShot(driver);
        return new TravelAboutUsResultPage(this.driver);
    }

    public void clickCarsLink() {
        clickElement(By.xpath(LINK_CARS_XPATH));
    }


    public void FullSearchForm(DataSearch dataSearch) throws InterruptedException {
        super.waitForElementToBeClickeable(By.xpath(TXT_PICKUP_XPATH));
        driver.findElementByXPath(TXT_PICKUP_XPATH).sendKeys(dataSearch.getPickUp());
        super.waitForElementToBeClickeable(By.xpath(DD_SELPICKUPSEARCH_XPATH));
        super.clickElement(By.xpath(DD_SELPICKUPSEARCH_XPATH));
        super.waitForElementInvisibility(By.xpath(DD_SELPICKUPSEARCH_XPATH));

        super.waitForElementToBeClickeable(By.xpath(TXT_DROPOFF_XPATH));
        driver.findElementByXPath(TXT_DROPOFF_XPATH).sendKeys(dataSearch.getDropOff());
        super.waitForElementToBeClickeable(By.xpath(DD_SELDROPOFFSEARCH_XPATH));
        super.clickElement(By.xpath(DD_SELDROPOFFSEARCH_XPATH));
        super.waitForElementInvisibility(By.xpath(DD_SELDROPOFFSEARCH_XPATH));

        super.waitForElementToBeClickeable(By.name(CAL_DEPARTDATE_NAME));
        super.completeField(By.name(CAL_DEPARTDATE_NAME), dataSearch.getDepartDate());
        driver.findElementByName(CAL_DEPARTDATE_NAME).sendKeys(Keys.TAB);
        super.completeField(By.name(CAL_RETURNDATE_NAME), dataSearch.getReturnDate());
        driver.findElementByName(CAL_RETURNDATE_NAME).sendKeys(Keys.TAB);

        super.waitForElementToBeClickeable(By.xpath(DD_DEPARTTIME_XPATH));
        super.clickElement(By.xpath(DD_DEPARTTIME_XPATH));
        departTimeXpathWithHour = "//*[@id=\"airDatepickerRange-flight\"]//ul/li[contains(@class, 'active-result') and contains(text(),'" + dataSearch.getDepartTime() + "') ]";
        super.waitForElementToBeClickeable(By.xpath(departTimeXpathWithHour));
        driver.findElementByXPath(departTimeXpathWithHour).click();
    }

    public TravelSearchResultPage clickSearchBtn() throws IOException {
        ExtentReportsConfig.ScreenShot(driver);
        clickElement(By.xpath(BTN_SEARCH_XPATH));
        return new TravelSearchResultPage(this.driver);
    }

}