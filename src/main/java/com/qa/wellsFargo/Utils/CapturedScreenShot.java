package com.qa.wellsFargo.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.wellsFargo.Base.Base;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CapturedScreenShot extends Base implements ITestListener {
	
	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed test");
			// get failed method name in screenshot
		failed(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

}
