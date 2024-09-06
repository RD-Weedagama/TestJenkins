package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        // Handle test failure (e.g., take a screenshot)
        System.out.println("Test failed: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting tests in: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finished tests in: " + context.getName());
    }
}