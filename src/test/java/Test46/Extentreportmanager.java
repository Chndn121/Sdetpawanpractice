package Test46;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ITestListener Interface of TestNG.
 * Generates Extent Reports for test execution.
 */
public class Extentreportmanager implements ITestListener {

    // Declare ExtentReports and ExtentTest objects outside the method
    private ExtentReports report;
    private ExtentTest test;

    
    public void onTestStart(ITestResult result) {
        // Test execution started
        String methodName = result.getMethod().getMethodName();
        test = report.createTest(methodName);
        test.log(Status.INFO, "-> " + methodName + " - Test Execution started <-");
    }

    
    public void onTestSuccess(ITestResult result) {
        // Test passed
        String methodName = result.getMethod().getMethodName();
        test.log(Status.PASS, "-> " + methodName + " - Test is Passed <-");
    }

    
    public void onTestFailure(ITestResult result) {
        // Test failed
        String methodName = result.getMethod().getMethodName();
        test.log(Status.FAIL, "-> " + methodName + " - Test is Failed <-");
        test.log(Status.WARNING, result.getThrowable());

        // Optionally take a screenshot for failed tests (uncomment if required)
        /*
        String screenShotName = methodName + "-" + new JavaUtility().getSystemDateinFormat();
        WebDriverUtility wUtil = new WebDriverUtility();
        try {
            String path = wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
            test.addScreenCaptureFromPath(path); // Attach screenshot to report
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    
    public void onTestSkipped(ITestResult result) {
        // Test skipped
        String methodName = result.getMethod().getMethodName();
        test.log(Status.SKIP, "-> " + methodName + " - Test is Skipped <-");
        test.log(Status.WARNING, result.getThrowable());
    }

    
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used but implemented as part of the ITestListener interface
    }

   
    public void onTestFailedWithTimeout(ITestResult result) {
        // Not used but implemented as part of the ITestListener interface
    }

   
    public void onStart(ITestContext context) {
        // Suite execution started
        System.out.println("-> Suite execution Started <-");

        // Configure the extent reports here
        ExtentSparkReporter htmlReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
        htmlReport.config().setDocumentTitle("Orange hrmReport");
        htmlReport.config().setReportName("Chandan - Automation Report");
        htmlReport.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(htmlReport);
        report.setSystemInfo("Base Browser", "Chrome");
        report.setSystemInfo("Base URL", "http://localhost:8888");
        report.setSystemInfo("Base Platform", "Windows 10");
        report.setSystemInfo("Reporter Name", "Chandankumar");
    }

    
    public void onFinish(ITestContext context) {
        // Suite execution finished
        System.out.println("-> Suite execution finished <-");

        // Generate and save the extent report
        report.flush();
    }
}
