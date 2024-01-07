package com.qa.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){}

    public static WebDriver getDriver(){
        return driver.get();
    }
    static void setDriver(WebDriver driverRef){
        if(Objects.nonNull(driverRef)){
            driver.set(driverRef);
        }
    }

    static void unload(){
        driver.remove();
    }

}
