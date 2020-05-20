package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TravelAboutUsResultPage extends PageBaseTravels {
    private final String LNK_ABOUTUS_XPATH = "//*[@id=\"toggleStyle04-headingOne\"]/h5/a";

    public TravelAboutUsResultPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public String GetLnkAboutUsText() {
      return  super.getElementText(By.xpath(LNK_ABOUTUS_XPATH));}

}
