package com.qa.listeners;

import com.qa.constants.FrameworkConstants;
import com.qa.reports.ExtentReport;
import com.qa.utils.elk.ELKUtils;
import com.qa.utils.excel.ExcelUtils;
import org.testng.*;

import java.util.Arrays;

import static com.qa.enums.LogType.*;
import static com.qa.reports.FrameworkLogger.*;


public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExcelUtils.downloadExcelFile(
                FrameworkConstants.getExcelGoogleDriveLink(),
                FrameworkConstants.getExcelFilePath()
        );

        ExtentReport.initReports();

    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log(PASS, result.getMethod().getMethodName() +" is passed");
        ELKUtils.sendResultToElk(result.getMethod().getMethodName(), "pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log(FAIL,result.getMethod().getMethodName() +" is failed");
        log(FAIL, result.getThrowable().toString());
        log(FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
        ELKUtils.sendResultToElk(result.getMethod().getMethodName(), "fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log(SKIP,result.getMethod().getMethodName() +" is skipped");
        ELKUtils.sendResultToElk(result.getMethod().getMethodName(), "skip");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
