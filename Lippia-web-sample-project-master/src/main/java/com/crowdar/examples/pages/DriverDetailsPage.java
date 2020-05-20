package com.crowdar.examples.pages;

import com.crowdar.examples.Reports.ExtentReportsConfig;
import com.crowdar.examples.Utils.DataDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class DriverDetailsPage extends PageBaseTravels {
    private final String DD_COUNTRYLIST_XPATH = "//ul[@id='ui-id-1']/li[1]";
    private final String BTN_CLOSEMESSAGE_XPATH = "//span[@class='ct-cancel']/i[@class='ct-icon-cancel']";
    private final String BTN_CLEANCOUNTRY_XPATH = "//i[@data-cta=\"country\"]";
    private final String TXT_FIRSTNAME_ID = "ct_firstname";
    private final String TXT_LASTNAME_ID = "ct_surname";
    private final String TXT_EMAIL_ID = "ct_email_address";
    private final String TXT_EMAILCONFIRM_ID = "ct_email_address_confirm";
    private final String DD_PHONEAREA_ID = "ct_phone_area_code";
    private final String TXT_PHONENO_ID = "ct_phone_no";
    private final String TXT_ADDRESS1_ID = "ct_address_1";
    private final String TXT_ADDRESS2_ID = "ct_address_2";
    private final String TXT_CITY_ID = "ct_city";
    private final String TXT_POSTALCODE_ID = "ct_postal_code";
    private final String TXT_COUNTRY_ID = "ct_country";
    private final String TXT_FLIGHT_ID = "ct_flight_no";
    private final String TXT_AGE_ID = "ct_age";
    private final String DD_PASSENGERS_ID = "ct_passengers";
    private final String BX_EXTRAS_ID = "ct_box_AddExtras";
    private final String DD_INSURANCES_ID = "ct_s3_insurance_select";
    private final String LB_ASSURANCES_ID = "ct_s3_assurance_select_txt";
    private final String LB_NEWSLETTER_ID = "ct_newsletter_label";
    private final String BTN_CONFIRM_XPTH = "//div[contains(@class, 'ct-btn') and contains(@data-cta,'MultiNext')]";
    private final String BX_ASSURANCEINSURANCE_ID = "ct_box_ExcessCover";


    public DriverDetailsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public PaymentPage FullForm(DataDriver dataDriver) throws InterruptedException, IOException {
        super.completeField(By.id(TXT_FIRSTNAME_ID), dataDriver.getFirstName());
        super.completeField(By.id(TXT_LASTNAME_ID), dataDriver.getLastName());
        super.completeField(By.id(TXT_EMAIL_ID), dataDriver.getEmail());
        super.completeField(By.id(TXT_EMAILCONFIRM_ID), dataDriver.getEmailConfirm());

        ScrollToElement(super.getWebElement(By.id(TXT_PHONENO_ID)));

        super.completeField(By.id(TXT_PHONENO_ID), dataDriver.getPhoneNo().toString());
        super.selectOptionDropdownByValue(By.id(DD_PHONEAREA_ID), dataDriver.getPhoneArea());
        super.completeField(By.id(TXT_ADDRESS1_ID), dataDriver.getAddress1());
        super.completeField(By.id(TXT_ADDRESS2_ID), dataDriver.getAddress2());
        super.completeField(By.id(TXT_CITY_ID), dataDriver.getCityID());
        super.completeField(By.id(TXT_POSTALCODE_ID), dataDriver.getPostalCode());

        try {
            if (isElementVisible(By.xpath(BTN_CLOSEMESSAGE_XPATH)))
                super.clickElement(By.xpath(BTN_CLOSEMESSAGE_XPATH));

        } catch (Exception e) {
            System.out.println("There's no message");
        }
        try {
            if (isElementVisible(By.xpath(BTN_CLOSEMESSAGE_XPATH)))
                super.clickElement(By.xpath(BTN_CLOSEMESSAGE_XPATH));
        } catch (Exception e) {
            System.out.println("There's no message");
        }

        super.clickElement(By.xpath(BTN_CLEANCOUNTRY_XPATH));
        super.completeField(By.id(TXT_COUNTRY_ID), dataDriver.getCountry());
        super.waitForElementToBeClickeable(By.xpath(DD_COUNTRYLIST_XPATH));
        driver.findElementById(TXT_COUNTRY_ID).sendKeys(Keys.ARROW_DOWN);
        driver.findElementById(TXT_COUNTRY_ID).sendKeys(Keys.ENTER);
        super.waitForElementInvisibility(By.xpath(DD_COUNTRYLIST_XPATH));

        super.waitForElementToBeClickeable(By.id(TXT_FLIGHT_ID));
        super.completeField(By.id(TXT_FLIGHT_ID), dataDriver.getFlight());
        super.completeField(By.id(TXT_AGE_ID), dataDriver.getAge().toString());
        super.clickElement(By.id(LB_NEWSLETTER_ID));
        super.selectOptionDropdownByText(By.id(DD_PASSENGERS_ID), dataDriver.getPassengers().toString());

        ExtentReportsConfig.ScreenShot(driver);

        ScrollToElement(super.getWebElement(By.id(BX_EXTRAS_ID)));


        //Codigo para interactuar con Assurances si se desea
     /*   try {
            if (super.isElementVisible(By.id(BX_ASSURANCEINSURANCE_ID))) {
                super.selectOptionDropdownByValue(By.id(DD_INSURANCES_ID), dataDriver.getInssurance());
                Thread.sleep(1000);
                super.clickElement(By.id(LB_ASSURANCES_ID));
            }
        } catch (Exception e) {
            System.out.println("ASSURANCES NOT VISIBLE");
        }*/

        super.waitForElementToBeClickeable(By.xpath(BTN_CONFIRM_XPTH));
        super.clickElement(By.xpath(BTN_CONFIRM_XPTH));


        return new PaymentPage(driver);

    }

    public void ScrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
