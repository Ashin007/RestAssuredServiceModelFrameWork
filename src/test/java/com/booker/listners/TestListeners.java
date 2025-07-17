package com.booker.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListeners.class);
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test succeeded "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: "+result.getName(),result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
