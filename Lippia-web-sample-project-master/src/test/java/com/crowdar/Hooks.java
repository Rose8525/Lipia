package com.crowdar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.Reports.ExtentReportsConfig;
import com.crowdar.examples.pages.PageBaseTravels;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReportsConfig.InitScenario(scenario.getName());
    }

    @After
    public void afterScenario() {
        ExtentReportsConfig.FlushReport();
        DriverManager.dismissCurrentDriver();
    }

}
