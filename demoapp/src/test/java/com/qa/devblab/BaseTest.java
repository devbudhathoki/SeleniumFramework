package com.qa.devblab;
import com.qa.driver.Driver;
import com.qa.utils.excel.ExcelUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Map;
public class BaseTest {

    protected BaseTest(){}


    protected void downloadExcelFromGoogleDrive(){
        ExcelUtils.downloadExcelFile(
                "https://docs.google.com/spreadsheets/d/1ooKRsMJarC8-tjI0GJUz8pQW49uooKOC-iNSiNPwF3w/pub?output=xlsx",
                System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
    }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data) throws Exception{

        Map<String,String> map = (Map<String, String>)data[0];
        Driver.initDriver(map.get("browser"),map.get("version"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
