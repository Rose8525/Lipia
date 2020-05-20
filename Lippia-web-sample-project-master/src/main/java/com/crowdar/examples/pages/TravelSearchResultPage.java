package com.crowdar.examples.pages;

import com.crowdar.examples.Reports.ExtentReportsConfig;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class TravelSearchResultPage extends PageBaseTravels {

    private final String BX_SEARCHRESULTSFIRST_XPATH = "//button[@class='ct-car-rate-btn ct-btn ct-btn-s ct-icon-right ct-icon-angle-right' and @data-car-index='0']";
    private final String FORM_RESULTS_XPATH = "//*[@id=\"ct_cars\"]/div";

    public TravelSearchResultPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public boolean FormResultsIsVisible() {
        return super.isElementVisible(driver.findElementByXPath(FORM_RESULTS_XPATH));
    }

    public DriverDetailsPage SelectFirstCarOption() throws InterruptedException, IOException {
        ExtentReportsConfig.ScreenShot(driver);
        clickElement(driver.findElementByXPath(BX_SEARCHRESULTSFIRST_XPATH));
        return new DriverDetailsPage(driver);
    }

}
