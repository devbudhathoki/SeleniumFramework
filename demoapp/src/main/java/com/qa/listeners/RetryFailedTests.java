package com.qa.listeners;

import com.qa.config.ConfigFactory;
import com.qa.enums.Retry;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int retries = 0;

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;

        if(ConfigFactory.getConfig().retrymode().equals(Retry.YES)){
            value = retries<1;
            retries++;
        }
        return value;
    }
}
