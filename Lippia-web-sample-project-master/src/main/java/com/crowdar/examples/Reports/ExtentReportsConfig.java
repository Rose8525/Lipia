package com.crowdar.examples.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReportsConfig {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest features;
    public static ExtentTest scenarioDef;
    public static ExtentReports extent;

    static {
        InitReportConfig();
    }

    private static void InitReportConfig() {
        String reportPath = "./target/Report/BDDReport.html";
        htmlReporter = new ExtentHtmlReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Enviroment", "QA");

        String extentConfigPath = "extent-config.xml";
        try {
            htmlReporter.loadXMLConfig(extentConfigPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ExtentReports GetInstance() {
        if (extent == null) {
            InitReportConfig();
        }
        return extent;
    }

    public static void InitScenario(String scenarioName) {
        if (ExtentReportsConfig.features == null)
            ExtentReportsConfig.features = ExtentReportsConfig.extent.createTest(Feature.class, "Initial Page Cars");
        ExtentReportsConfig.scenarioDef = ExtentReportsConfig.features.createNode(scenarioName);
    }

    public static ExtentTest CreateNode(String gherkinKeyword, String name) throws ClassNotFoundException {
        return ExtentReportsConfig.scenarioDef.createNode(new GherkinKeyword(gherkinKeyword), name);
    }


    public static void ScreenShot(RemoteWebDriver remoteWebDriver) throws IOException {
        String guid = java.util.UUID.randomUUID().toString();
        File a = ((TakesScreenshot) remoteWebDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(a, new File("./target/Report/" + guid + ".png"));
        scenarioDef.pass("Details").addScreenCaptureFromPath( guid + ".png");
    }

    public static void FlushReport() {
        extent.flush();
    }
}
