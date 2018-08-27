package com.demo.automation.objectrepositories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Cart {
	
	public WebDriver driver;
	Actions action;
	
	public Cart(WebDriver driver) {
		this.driver = driver; 
		action = new Actions(driver);
	}
	
	/*****WebElement Locators*****/
	//Nav Bar
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
	

	
	/*****WebElement Methods*****/
	
	public boolean ConfirmItemInCart(String itemName, int itemQuantity) {
		
		boolean confirmedInCart = false;
		List<WebElement> checkoutList = driver.findElements(By.xpath("//tr[contains(@class, 'product_row product')]")); 
		
		for (int i = 0 ; i < checkoutList.size() ; i++) {
			
			String name = driver.findElement(By.xpath("//tr[contains(@class, 'product_row product_row_" + i + "')]//td[@class='wpsc_product_name wpsc_product_name_" + i + "']")).getText(); 
			String quantity = driver.findElement(By.xpath("//tr[contains(@class, 'product_row product_row_" + i + "')]/td[3]/form/input[1]")).getAttribute("value");
			if(name.equals(itemName) && quantity.equals(Integer.toString(itemQuantity))) {
				
				confirmedInCart = true;
				
			}else {
				
				confirmedInCart = false;
			}
		}
		
		return confirmedInCart;
	}
	
	
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
	
	
	public WebElement getCheckout() {
		
		return driver.findElement(checkout);
	}
	
	
	public WebElement getItemCount() {
		
		return driver.findElement(itemCount);
	}
	
	
	public WebElement getMyAccount() {
		
		return driver.findElement(myAccount);
	}
	
	
	public WebElement getProductName() {
		
		return driver.findElement(productName);
	}
	
	
	public WebElement getQuantity() {
		
		return driver.findElement(quantity); 
	}
	
	public WebElement getUpdate() {
		
		return driver.findElement(update);
	}
	
	
	public WebElement getRemove() {
		
		return driver.findElement(remove);
	}
	
	
	public WebElement getContinue() {
		
		return driver.findElement(cont);
	}
	
}
