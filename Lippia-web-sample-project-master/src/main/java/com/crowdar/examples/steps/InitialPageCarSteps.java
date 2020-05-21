package com.crowdar.examples.steps;

import com.aventstack.extentreports.GherkinKeyword;
import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.Reports.ExtentReportsConfig;
import com.crowdar.examples.Utils.*;
import com.crowdar.examples.pages.DriverDetailsPage;
import com.crowdar.examples.pages.PaymentPage;
import com.crowdar.examples.pages.TravelHomePage;
import com.crowdar.examples.pages.TravelSearchResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.jsoup.helper.Validate;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class InitialPageCarSteps extends PageSteps {
    @Given("The user is in Cars page")
    public void theUserIsInCarsPage() throws ClassNotFoundException, IOException {
        try {
            Injector._page(TravelHomePage.class).go();
            ExtentReportsConfig.CreateNode("Given", "The user is in Cars page").pass("Passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("Given", "The user is in Cars page").fail("Failed");
        }
    }


    @When("The user search a car between two days")
    public void theUserSearchACarBetweenTwoDays(DataTable dataTable) throws InterruptedException, ClassNotFoundException, IOException {
        try {
            List<DataSearch> dataSearchList = DataSearchFromDataTable.getSearchFromDataTable(dataTable);
            Injector._page(TravelHomePage.class).clickCarsLink();
            ExtentReportsConfig.ScreenShot(Injector._page(TravelHomePage.class).getDriver());
            Injector._page(TravelHomePage.class).FullSearchForm(dataSearchList.get(0));
            Injector._page(TravelHomePage.class).clickSearchBtn();
            ExtentReportsConfig.CreateNode("When", "The user search a car between two days").pass("Passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("When", "The user search a car between two days").fail("Failed");
        }
    }


    @Then("The search page list the available cars in those days.")
    public void theSearchPageListTheAvailableCarsInThoseDays() throws ClassNotFoundException, IOException {
        try {
            Assert.assertTrue(Injector._page(TravelSearchResultPage.class).FormResultsIsVisible());
            ExtentReportsConfig.CreateNode("Then", "The search page list the available cars in those days.").pass("Passed");
            ExtentReportsConfig.ScreenShot(Injector._page(TravelSearchResultPage.class).getDriver());
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("Then", "The search page list the available cars in those days.").fail("Failed");
        }
    }


    @And("the user select the first result in the list")
    public void theUserSelectTheFirstResultInTheList() throws InterruptedException, ClassNotFoundException, IOException {
        try {
            Injector._page(TravelSearchResultPage.class).SelectFirstCarOption();
            ExtentReportsConfig.CreateNode("And", "the user select the first result in the list").pass("Passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("And", "the user select the first result in the list").fail("Failed");
        }
    }


    @And("The user complete the booking car form")
    public void theUserCompleteTheBookingCarForm() throws Exception {
        try {
            List<DataDriver> dataDriverList = DataFromJSON.GetFromFile("C:\\Users\\Usuario\\IdeaProjects\\Lippia-web-sample-project-master\\src\\main\\java\\com\\crowdar\\examples\\Utils\\Data.json");
            Injector._page(DriverDetailsPage.class).FullForm(dataDriverList.get(0));
            ExtentReportsConfig.CreateNode("And", "The user complete the booking car form").pass("Passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("And", "The user complete the booking car form").fail("Failed");
        }
    }


    @And("The user complete the payment form <payment data provided below>")
    public void theUserCompleteThePaymentFormPaymentDataProvidedBelow(DataTable dataTable) throws InterruptedException, ClassNotFoundException, IOException {
        try {
            List<DataPayment> dataPaymentList = DataFromDataTable.GetFromDataTable(dataTable);
            Injector._page(PaymentPage.class).FullPaymentForm(dataPaymentList.get(0));
            ExtentReportsConfig.CreateNode("And", "The user complete the payment form <payment data provided below>").pass("Passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("And", "The user complete the payment form <payment data provided below>").fail("Failed");
        }
    }


    @Then("a reservation number is provided")
    public void aReservationNumberIsProvided() throws IOException, ClassNotFoundException {
        try {
            Assert.assertTrue(Injector._page(PaymentPage.class).IsReservationConcrete());
            ExtentReportsConfig.CreateNode("Then", "a reservation number is provided").pass("Passed");
            ExtentReportsConfig.ScreenShot(Injector._page(PaymentPage.class).getDriver());
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("Then", "a reservation number is provided").fail("Failed");
        }
    }

// METODO UTILIZADO CUANDO NO SE CONCRETABA LA RESERVA
 /*   @Then("an error alert message is show : {string}")
    public void anErrorAlertMessageIsShow(String alertMessage) throws ClassNotFoundException, IOException, InterruptedException {
        Assert.assertTrue(Injector._page(PaymentPage.class).ValidateAlertMessage(alertMessage));
        ExtentReportsConfig.CreateNode("Then", "an error alert message is show : {string}").pass("Passed");
        ExtentReportsConfig.ScreenShot(Injector._page(PaymentPage.class).getDriver());
    }*/
}
