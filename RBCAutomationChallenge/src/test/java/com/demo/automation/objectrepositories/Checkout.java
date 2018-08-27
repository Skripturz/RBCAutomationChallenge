package com.demo.automation.objectrepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
	
	public WebDriver driver;
	Select select;
	Actions action;
	
	public Checkout(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
	}
	
/*****WebElement Locators*****/
	
	//Nav Bar Locatators
	By home = By.xpath("//a[text()='Home']");
	
	//Product Category
	By productCategory = By.xpath("//a[text()='Product Category']");
	By accessories = By.xpath("//a[text()='Accessories']");
	By iMacs = By.xpath("//a[text()='iMacs']");
	By iPads = By.xpath("//a[text()='iPads']");
	By iPhones = By.xpath("//a[text()='iPhones']");
	By iPods = By.xpath("//a[text()='iPods']");
	By macBooks = By.xpath("//a[text()='MacBooks']");
	
	By noTitle = By.xpath("//a[text()='#0 (no title)']"); //Not Utilized
	By allProduct = By.xpath("//a[text()='All Product']");
	By search = By.xpath("//input[@class='search']");
	
	//Tools Bar
	By tools = By.xpath("//img[@alt='home']");
	By checkout = By.xpath("//a[text()='Checkout']");
	By itemCount = By.xpath("//em[@class='count']");
	By myAccount = By.xpath("//a[text()='My Account']");
	
	By productName = By.xpath("//div[@class='slide1']/descendant::a[contains(@href, 'http://store.demoqa.com')]");
	By quantity = By.xpath("//td[@class='wpsc_product_quantity wpsc_product_quantity_0']//form/input[@name='quantity']");
	By update = By.xpath("//input[@value='Update']");
	By remove = By.xpath("//input[@value='Remove']");
	By cont = By.xpath("//a[@class='step2']");
	
	//Check out form Locators
	By calculateShippingCountry = By.xpath("//select[@name='country']"); 
	public By email = By.xpath("//input[@title='billingemail']");
	public By emailAvatar = By.xpath("//img[@id='wpsc_checkout_gravatar']");
	By billFirstName = By.xpath("//input[@title='billingfirstname']");
	By billLastName = By.xpath("//input[@title='billinglastname']");
	By billAddress = By.xpath("//textarea[@title='billingaddress']");
	By billCity = By.xpath("//input[@title='billingcity']");
	By billState = By.xpath("//input[@title='billingstate']");
	By billCountry = By.xpath("//select[@title='billingcountry']");
	By billPostalCode = By.xpath("//input[@title='billingpostcode']");
	By billPhone = By.xpath("//input[@title='billingphone']");
	By sameAsBilling = By.xpath("//input[@name='shippingSameBilling']");
	By goBack = By.xpath("//a[@class='step1']");
	By purchase = By.xpath("//input[@value='Purchase']");
	
	
/*****WebElement Methods*****/
	
	
	public WebElement getHome() {
		
		return driver.findElement(home);
	}
	
	
	public WebElement getProductCategory() {
		
		return driver.findElement(productCategory);
	}
	
	
	public void moveToProductCategory() {
		
		action.moveToElement(driver.findElement(productCategory)).build().perform();
	}
	public WebElement getAccessories() {
		
		moveToProductCategory();
		return driver.findElement(accessories);
	}
	
	
	public WebElement getiMacs() {
		
		moveToProductCategory();
		return driver.findElement(iMacs);
	}
	
	
	public WebElement getiPads() {
		
		moveToProductCategory();
		return driver.findElement(iPads);
	}
	
	
	public WebElement getiPhones() {
		
		moveToProductCategory();
		return driver.findElement(iPhones);
	}
	
	
	public WebElement getiPods() {
		
		moveToProductCategory();
		return driver.findElement(iPods);
	}
	
	
	public WebElement getMacBooks() {
		
		moveToProductCategory();
		return driver.findElement(macBooks);
	}
	
	
	//No Title Method Implementation Here
	

	public WebElement getAllProduct() {
		
		return driver.findElement(allProduct);
	}
	
	
	public WebElement getSearch() {
		
		return driver.findElement(search);
	}
	
	
	public WebElement getTools() {
		
		return driver.findElement(tools);
	}
	
	
	//Check out  Methods
	
	public WebElement getCalculateShippingCountry() {
		
		return driver.findElement(calculateShippingCountry);
	}
	
	
	public WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
	public WebElement getEmailAvatar() {
		
		return driver.findElement(emailAvatar); 
	}
	
	
	public WebElement getBillingFirstName() {
		
		return driver.findElement(billFirstName);
	}
	
	
	public WebElement getBillingLastName() {
		
		return driver.findElement(billLastName);
	}
	
	
	public WebElement getBillingAddress() {
		
		return driver.findElement(billAddress);
	}
	
	
	public WebElement getBillingCity() {
		
		return driver.findElement(billCity);
	}
	
	
	public WebElement getBillingState() {
		
		return driver.findElement(billState);
	}
	
	
	public Select getBillingCountry() {
		
		return new Select(driver.findElement(billCountry));
				
	}
	
	
	public WebElement getBillPostalCode() {
		
		return driver.findElement(billPostalCode);
	}
	
	
	public WebElement getBillingphone() {
		
		return driver.findElement(billPhone);
	}
	

	public WebElement getSameAsBilling() {
		
		return driver.findElement(sameAsBilling);
	}
	
	
	public WebElement getGoBack() {
		
		return driver.findElement(goBack);
	}
	
	
	public WebElement getPurchase() {
		
		return driver.findElement(purchase);
	}
	

}
