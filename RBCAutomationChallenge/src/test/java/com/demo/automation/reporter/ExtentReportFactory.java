package com.demo.automation.reporter;

import java.io.File;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demo.automation.constant.Constant;
/**
 * @author Rohit Kumar
 *
 */
public class ExtentReportFactory {

	private static ExtentHtmlReporter htmlReporter;

	private static ExtentReports reporter;

	public static synchronized ExtentReports getReporter() {

		String workspace = ((new File(".").getAbsolutePath()).replace("\\", "/")).replace(".", "");
		String fileName = workspace + "src/test/resources/extent_config.xml";
		File file = new File(fileName);
		if (reporter == null) {
			htmlReporter = new ExtentHtmlReporter(Constant.REPORTPATH);
			htmlReporter.loadXMLConfig(file);
			reporter = new ExtentReports();
			reporter.attachReporter(htmlReporter);
			reporter.setSystemInfo("Author", "Rohit");
			reporter.setSystemInfo("User Name", "Automation");
			reporter.setSystemInfo("Environment", "Dev");
			reporter.setSystemInfo("Selenium Version", "3.14.0");
			reporter.setAnalysisStrategy(AnalysisStrategy.CLASS);
		}
		return reporter;
	}
}
