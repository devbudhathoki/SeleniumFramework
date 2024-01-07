package com.qa.factories;

import com.qa.constants.FrameworkConstants;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

        private ExplicitWaitFactory() {}


        public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
            WebElement element = null;
            if(waitstrategy == WaitStrategy.CLICKABLE) {
                element = 	new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                        .until(ExpectedConditions.elementToBeClickable(by));
            }
            else if(waitstrategy == WaitStrategy.PRESENCE) {
                element =	new WebDriverWait(DriverManager.getDriver(),  FrameworkConstants.getExplicitwait())
                        .until(ExpectedConditions.presenceOfElementLocated(by));
            }
            else if(waitstrategy == WaitStrategy.VISIBLE) {
                element =new WebDriverWait(DriverManager.getDriver(),  FrameworkConstants.getExplicitwait())
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            else if(waitstrategy == WaitStrategy.NONE) {
                element = DriverManager.getDriver().findElement(by);
            }
            return element;
        }

}
