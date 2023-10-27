package com.qa.devblab;

import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Config;
import com.qa.config.ConfigFactory;
import com.qa.config.FrameworkConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testlogin() {

        System.out.println(ConfigFactory.getConfig().browser());
        // WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();
        // driver.get("http://google.com");
        // driver.quit();

    }
}
