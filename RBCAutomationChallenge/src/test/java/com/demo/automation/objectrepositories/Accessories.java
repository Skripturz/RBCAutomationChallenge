package com.demo.automation.objectrepositories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Accessories{
	
	public WebDriver driver;
	public int itemCount;
	Actions action;
	public Accessories(WebDriver driver) {
		this.driver = driver; 
		itemCount = Integer.parseInt(getCartItemCount().getText());
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
	By myAccount = By.xpath("//a[text()='My Account']");
	
	By grid = By.xpath("//a[@title='Grid View']");
	By list = By.xpath("//a[@title='Default View']");
	
	By register = By.xpath("//a[text()='Register']");
	By login = By.xpath("//a[text()='Log in']");
	By magicMouse = By.xpath("//a[text()='Log in']");
	
	By productHeaders = By.xpath("//a[@class='wpsc_product_title']");
	//By products = By.xpath("//div[contains(@class,'default_product_display')]");
	
	public By accessoriesHeader = By.xpath("//h1[@class='entry-title']");
	
	By cartItemCount = By.xpath("//em[@class='count']"); //return the current # of items in cart
	
	/*String acc = prop.getProperty("accessories");
	public By accessoriesTitle = By.xpath("//h2/a[text()="+"'"+acc+"'"+"]");*/
	
	/*****WebElement Methods*****/
	
	/*public List<WebElement> getProducts() {
		return driver.findElements(products);
	}*/
	
	public int getItemCount() {
		
		return itemCount;
	}
	
	public WebElement getCartItemCount() {
		
		return driver.findElement(cartItemCount);
	}
	
	
	public void AddToCart(String itemName, int quantity) {
		
		//loop through the number of quantities
		for(int j = 1 ; j <= quantity ; j++) {
			
			//search for the element and click the respective add to card button
			List<WebElement> productName = driver.findElements(productHeaders);
			String expectedProduct = itemName;
			int i = 3;
			for (WebElement product : productName) {
				String actualProduct = product.getText();
				if (actualProduct.equals(expectedProduct)) {
					driver.findElement(
							By.xpath("//div[@id='default_products_page_container']/div[" + i + "]//input[@type='submit']"))
							.click();
					itemCount++;
					break;
				}
				i++;
			}
		}
	}
	
	
	public List<WebElement> getProductHeaders() {
		return driver.findElements(productHeaders);
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
	
	
	public WebElement getMyAccount() {
		
		return driver.findElement(myAccount);
	}
	
	
	public WebElement getGridView() {
		
		return driver.findElement(grid);
	}
	
	
	public WebElement getListView() {
		
		return driver.findElement(list);
	}
	
	
	public WebElement getRegister() {
		
		return driver.findElement(register);
	}
	
	
	public WebElement getLogin() {
		
		return driver.findElement(login);
	}
	
	
}
