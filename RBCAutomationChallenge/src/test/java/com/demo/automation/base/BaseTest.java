package com.demo.automation.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demo.automation.constant.Constant;
import com.demo.automation.objectrepositories.Accessories;
import com.demo.automation.objectrepositories.Cart;
import com.demo.automation.objectrepositories.Checkout;
import com.demo.automation.objectrepositories.HomePage;
import com.demo.automation.objectrepositories.TransactionResults;
import com.demo.automation.reporter.ReportGenerator;
import com.demo.automation.testcases.PurchaseTest;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	protected ReportGenerator reporter;
	protected HomePage homePage;
	protected Accessories accessoriesPage;
	protected Cart cartPage;
	protected Checkout checkout;
	protected TransactionResults tr;
	
	static {
		prop= new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(Constant.PROPERTYFILEPATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Logger log = LogManager.getLogger(PurchaseTest.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
	}
	
	public WebDriver initializeDriver() throws IOException {
		
		/*****Create & Load Properties File*****/
		String browserName = prop.getProperty("browser");
		
		/*****Check & Initiate Browser Driver*****/
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
					
		} else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();	
		} 
		
		/*****Configure Driver*****/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		String methodName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			String res = result.getThrowable().getMessage();
			Exception e = new Exception();
			reporter.logScreenshot(driver, methodName, res, e);
		} 
		driver.close();
		driver= null;
		log.info("Browser Closed");
		reporter.flush();
	}

}
