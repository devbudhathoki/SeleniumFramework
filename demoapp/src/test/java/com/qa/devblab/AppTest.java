package com.qa.devblab;

import com.qa.utils.ChromeDriverVersions;
import com.qa.utils.excel.ExcelUtils;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test(Method method) {
//        System.out.println(ConfigFactory.getConfig().browser());
//        System.out.println(ConfigFactory.getConfig().url());
//        System.out.println(ConfigFactory.getConfig().retrymode());
//        Driver.initDriver("chrome","88.0.4324.96");
//        System.out.println(ChromeDriverVersions.getVersions());
       ExcelUtils.downloadExcelFile(

                "https://docs.google.com/spreadsheets/d/1ooKRsMJarC8-tjI0GJUz8pQW49uooKOC-iNSiNPwF3w/pub?output=xlsx",
                System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
//        System.out.println(DataProviderUtils.getData(method));
        // WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();
        // driver.get("http://google.com");
        // driver.quit();

    }
}
