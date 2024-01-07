package com.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent = null;

    public static void initReports() {

        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setDocumentTitle("Test Report");
            spark.config().setReportName("Sample Project Testing");
            spark.config().setTheme(Theme.STANDARD);

        }
    }

        public static void tearDownReports(){
            if(Objects.nonNull(extent)){
                extent.flush();
            }
            ExtentManager.unload();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public static void createTest(String testcasename) {
        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }


}
