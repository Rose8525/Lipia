package com.crowdar.examples.steps;

import com.aventstack.extentreports.Status;
import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.Reports.ExtentReportsConfig;
import com.crowdar.examples.pages.TravelAboutUsResultPage;
import com.crowdar.examples.pages.TravelHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class InitialPageSteps extends PageSteps {
    @Given("The user is in home page")
    public void theUserIsInHomePage() throws ClassNotFoundException, IOException {
        try {
            Injector._page(TravelHomePage.class).go();
            ExtentReportsConfig.CreateNode("Given", "The user is in home page").pass("Passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("Given", "The user is in home page").fail("Failed");
        }
    }

    @When("The user go to {string} page")
    public void theUserGoToPage(String aboutUs) throws ClassNotFoundException, IOException {
        try {
            Injector._page(TravelHomePage.class).clickAboutUsLink();
            ExtentReportsConfig.CreateNode("When", "The user go to {string} page").pass("Passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("When", "The user go to {string} page").fail("Failed");
        }

    }

    @Then("The {string} page is displayed")
    public void thePageIsDisplayed(String aboutUs) throws ClassNotFoundException, IOException {
        try {
            Assert.assertEquals(Injector._page(TravelAboutUsResultPage.class).GetLnkAboutUsText(), aboutUs);
            ExtentReportsConfig.CreateNode("Then", "The {string} page is displayed").pass("Passed");
            ExtentReportsConfig.features.log(Status.PASS, "Test passed");
        } catch (Throwable t) {
            ExtentReportsConfig.CreateNode("Then", "The {string} page is displayed").fail("Failed");
            ExtentReportsConfig.features.log(Status.FAIL, "Test failed");

        }
    }
}
