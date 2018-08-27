package com.demo.automation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.automation.customexception.CustomException;

public class SeleniumUtility {

	public static WebElement presenceOfElement(WebDriver driver,By by) throws Exception{
		try {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(by));
	}
		catch(Exception e) {
			throw new CustomException("Element is not available");
		}
	}
	
	public static Boolean textToBePresentInElement(WebDriver driver, WebElement element, String text) throws Exception {
		try {
			return new WebDriverWait(driver, 20).until(ExpectedConditions.textToBePresentInElement(element, text));
		}
		catch(Exception e) {
			throw new CustomException("Element is not available");
		}
	}
	
	public static WebElement visibilityOfElement(WebDriver driver,WebElement element) throws Exception{
		try {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
	}
		catch(Exception e) {
			throw new CustomException("Element is not available");
		}
	}
	

}
