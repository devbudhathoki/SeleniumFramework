package com.qa.pages;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.enums.LogType.*;
import static com.qa.reports.FrameworkLogger.*;

public class BasePage {

    protected void click(By by, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        log(PASS,elementname+" is clicked");

    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementname){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
        log(PASS,value +" is entered successfully in "+ elementname);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
