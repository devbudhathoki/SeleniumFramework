package com.qa.constants;


import com.qa.config.ConfigFactory;
import lombok.Getter;
import org.testng.annotations.DataProvider;
import org.testng.util.TimeUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FrameworkConstants {

    private FrameworkConstants(){}
    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String EXCEL_FILE_PATH = RESOURCESPATH + "/excel/testdata.xlsx";
    private static final String CHROME_DRIVER_URL= "https://googlechromelabs.github.io/chrome-for-testing/known-good-versions.json";
    private static final String RUNMANAGER_SHEET ="RUNMANAGER";
    private static final String DATA_SHEET ="DATA";
    private static final int EXPLICIT_WAIT = 10;
    private static final String EXCEL_GOOGLE_DRIVE_LINK = "https://docs.google.com/spreadsheets/d/1ooKRsMJarC8-tjI0GJUz8pQW49uooKOC-iNSiNPwF3w/pub?output=xlsx";
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath = "";

    public static String getExcelFilePath(){
        return EXCEL_FILE_PATH;
    }

    public static String getChromeDriverURL(){
        return CHROME_DRIVER_URL;
    }

    public static String getRunmanagerSheet(){
        return RUNMANAGER_SHEET;
    }

    public static String getDataSheet(){
        return DATA_SHEET;
    }

    public  static  Duration getExplicitwait(){
        return Duration.ofSeconds(EXPLICIT_WAIT);
    }

    public static String getExcelGoogleDriveLink(){
        return EXCEL_GOOGLE_DRIVE_LINK;
    }

    public static String getExtentReportFolderPath(){
        return EXTENT_REPORT_FOLDER_PATH;
    }

    public static String getExtentReportFilePath()  {
        if(extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath()  {
        if(ConfigFactory.getConfig().overrideReports().equalsIgnoreCase("no")) {
            return EXTENT_REPORT_FOLDER_PATH+System.currentTimeMillis()+"/index.html";
        }
        else {
            return EXTENT_REPORT_FOLDER_PATH+"/index.html";
        }
    }

}
