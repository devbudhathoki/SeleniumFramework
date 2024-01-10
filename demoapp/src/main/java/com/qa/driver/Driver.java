package com.qa.driver;

import com.qa.config.ConfigFactory;
import com.qa.exceptions.BrowserInvocationFailedException;
import com.qa.factories.DriverFactory;

import java.util.Objects;
/**
 * Driver
 * Driver class is responsible for invoking and closing the browsers.
 *
 * <p>
 *     It is also responsible for setting the driver variable to DriverManager which handles the thread saftey for
 *     the webdriver instance
 * </p>
 * Jan 8 2024
 * @author Dev Budhathoki
 * @version 1.0
 * @see DriverManager
 */
public class Driver {
    /**
     * Private constructor to avoid external instantiation
     */
    private Driver(){}

    /**
     *
     * @param browser Value will be passed from BaseTest. Values can be chrome and firefox
     * @param version Value will be passed from BaseTest. Values are chrome and firefox versions.
     */
    public static void initDriver(String browser, String version){
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser, version));
            } catch (Exception e) {
                throw new BrowserInvocationFailedException("please check the capabilities of browser");
            }
            DriverManager.getDriver().get(ConfigFactory.getConfig().url().toString());
        }

    }

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
