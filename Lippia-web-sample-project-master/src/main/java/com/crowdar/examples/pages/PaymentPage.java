package com.crowdar.examples.pages;

import com.crowdar.examples.Reports.ExtentReportsConfig;
import com.crowdar.examples.Utils.DataPayment;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class PaymentPage extends PageBaseTravels {
    private final String TXT_CARDNUMBER_ID = "cardNumber";
    private final String TXT_CARDHOLDER_ID = "cardName";
    private final String TXT_CCV_ID = "seriesCode";
    private final String DD_EXPIRYDATEMONTH_ID = "expiryDateMonth";
    private final String DD_EXPIRYDATEYEAR_ID = "expiryDateYear";
    private final String BTN_BOOK_XPTH = "//input[contains(@value, 'Book Now')]";
    private final String BTN_UPPAGE_ID = "back-to-top";
    private final String BX_IFRAME_ID = "ct-secure-payment";
    private final String TT_RESERVATIONCONFIRM_XPTH = "//h4[contains(text(),'Your reservation number')]";
    // String alertMessage; // UTILIZADO CUANDO NO SE CONCRETABA LA RESERVA


    public PaymentPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void FullPaymentForm(DataPayment dataPayment) throws InterruptedException, IOException {

        super.clickElement(By.id(BTN_UPPAGE_ID));

        driver.switchTo().frame(super.getWebElement(By.id(BX_IFRAME_ID)));

        super.waitForElementToBeClickeable((By.id(TXT_CARDNUMBER_ID)));
        super.completeField(By.id(TXT_CARDNUMBER_ID), dataPayment.getCardNumber());

        super.completeField(By.id(TXT_CARDHOLDER_ID), dataPayment.getCardHolderName());

        super.selectOptionDropdownByValue(By.id(DD_EXPIRYDATEMONTH_ID), dataPayment.getExpiryDateMonth());
        super.selectOptionDropdownByText(By.id(DD_EXPIRYDATEYEAR_ID), dataPayment.getExpiryDateYear());

        super.completeField(By.id(TXT_CCV_ID), dataPayment.getSeriesCode());

        ExtentReportsConfig.ScreenShot(driver);

        super.waitForElementToBeClickeable((By.xpath(BTN_BOOK_XPTH)));
        driver.findElementByXPath(BTN_BOOK_XPTH).submit();

        driver.switchTo().defaultContent();


        //UTILIZADO CUANDO NO SE CONCRETABA LA RESERVA
       /* super.getWait().until(ExpectedConditions.alertIsPresent());
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();*/
    }

    public boolean IsReservationConcrete() {
        try {
            if (super.isElementVisible(By.xpath(TT_RESERVATIONCONFIRM_XPTH)))
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    //METODO UTILIZADO CUANDO NO SE CONCRETABA LA RESERVA
    /*public boolean ValidateAlertMessage(String alertExpected) throws InterruptedException {
        boolean value = false;
        if (alertExpected.equals(alertMessage))
            value = true;

        return value;
    }*/

}


