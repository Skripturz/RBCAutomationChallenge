package com.demo.automation.reporter;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demo.automation.constant.Constant;
import com.demo.automation.customexception.CustomException;

public class ReportGenerator {
	
	ExtentTest childTest;
	ExtentTest parentTest;
	
	private static ExtentReports reporter = ExtentReportFactory.getReporter();
	
	public ReportGenerator (String methodName, String author, String category){
		parentReport( methodName, author, category);
	}
	
	public void parentReport( String methodName,String author, String category) {
		parentTest = reporter.createTest(methodName);
		parentTest.assignAuthor(author);
		parentTest.assignCategory(category);
	}

	public void childReport(String methodName) {
		childTest = parentTest.createNode(methodName);
		childTest.log(Status.PASS, methodName);
	}

	public void flush(){
		reporter.flush();
	}
	
	
	public void logScreenshot(WebDriver screenDriver, String testCaseName, String res, Exception e) throws IOException{
		try{
			File file  = ((TakesScreenshot)screenDriver).getScreenshotAs(OutputType.FILE);
			File dir = new File(Constant.SCREENSHOTPATH+testCaseName);
			dir.mkdirs();
			
			String workspace = 	((new File(".").getAbsolutePath()).replace("\\", "/")).replace(".", "");
			String fileName= workspace+Constant.SCREENSHOTPATH+testCaseName+"/"+testCaseName+".jpg";
			FileUtils.copyFile(file, new File(fileName));
			ExtentTest logger = this.childTest;
			logger.fail(e);
			logger.info("Attached screen shot").addScreenCaptureFromPath("screenshot/"+testCaseName+"/"+testCaseName+".jpg");
			
		}
		catch (CustomException ce) {
			ce.printStackTrace();
			throw new CustomException("Custom Exception while taking Screenshot: "+ce);
		}
		catch(Exception ex){
			throw new CustomException("Exception while taking screen  shot: "+ex);
		}		
	}
}
