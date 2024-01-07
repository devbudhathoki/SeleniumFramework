package com.qa.driver;

import com.qa.config.ConfigFactory;
import com.qa.exceptions.BrowserInvocationFailedException;
import com.qa.factories.DriverFactory;

import java.util.Objects;

public class Driver {

    private Driver(){}

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
