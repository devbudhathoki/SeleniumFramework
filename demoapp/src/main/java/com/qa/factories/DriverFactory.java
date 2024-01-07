package com.qa.factories;

import com.qa.config.ConfigFactory;
import com.qa.enums.BrowserType;
import com.qa.enums.RUNMODE;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    public static WebDriver getDriver(String browser, String version) {
        WebDriver webDriver = null;

        RUNMODE runmode = ConfigFactory.getConfig().runmode();
        URL url = ConfigFactory.getConfig().url();
        BrowserType browsertype =  BrowserType.valueOf(browser.toUpperCase());
        if (browsertype.equals(BrowserType.CHROME)) {
            if (runmode.equals(RUNMODE.REMOTE)) {
                System.out.println("I am here");
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME.toString());
                cap.setVersion(version);
                webDriver = new RemoteWebDriver(url, cap);
            } else {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
        }
        else if (browsertype == BrowserType.FIREFOX) {

            if(runmode.equals(RUNMODE.REMOTE)){
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.FIREFOX.toString());
                cap.setVersion(version);
                webDriver = new RemoteWebDriver(url, cap);
            }
            else{
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }

        }
        return  webDriver;
    }


}
