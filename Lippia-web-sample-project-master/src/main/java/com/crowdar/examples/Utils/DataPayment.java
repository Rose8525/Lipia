package com.crowdar.examples.Utils;

public class DataPayment {
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getExpiryDateMonth() {
        return expiryDateMonth;
    }

    public void setExpiryDateMonth(String expiryDateMonth) {
        this.expiryDateMonth = expiryDateMonth;
    }

    public String getExpiryDateYear() {
        return expiryDateYear;
    }

    public void setExpiryDateYear(String expiryDateYear) {
        this.expiryDateYear = expiryDateYear;
    }

    private String cardNumber;
    private String cardHolderName;
    private String seriesCode;
    private String expiryDateMonth;
    private String expiryDateYear;
}
