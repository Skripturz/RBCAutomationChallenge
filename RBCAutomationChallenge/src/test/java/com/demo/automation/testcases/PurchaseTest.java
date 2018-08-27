package com.demo.automation.testcases;


import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.automation.base.BaseTest;
import com.demo.automation.objectrepositories.Accessories;
import com.demo.automation.objectrepositories.Cart;
import com.demo.automation.objectrepositories.Checkout;
import com.demo.automation.objectrepositories.HomePage;
import com.demo.automation.objectrepositories.TransactionResults;
import com.demo.automation.reporter.ReportGenerator;
import com.demo.automation.utilities.ExcelUtility;
import com.demo.automation.utilities.SeleniumUtility;


public class PurchaseTest extends BaseTest {
	
	
	@Test(dataProvider="getData") 
	public void purchaseMagicMouse(String item, int quantity, String email, String bfirstname, String blastname, String baddress, String bcity, String bstate, 
			String bcountry, String bpostalcode, String bphone, String saba) throws Exception {
		
		String category = "Smoke";
		String className = this.getClass().getSimpleName();
		String author = "Rohit";
		reporter = new ReportGenerator(className,author, category);
		
		log.info("STEP 1: go to url");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to url: " + prop.getProperty("url"));
		reporter.childReport("STEP 1: Navigated to url: " + prop.getProperty("url"));
		
		//Page Objects
		homePage = new HomePage(driver);
		accessoriesPage = new Accessories(driver);
		cartPage = new Cart(driver);
		checkout = new Checkout(driver);
		tr = new TransactionResults(driver);
		log.info("Initialized page objects");
		
		
		log.info("STEP 2: Go to Product category and select Accessories");
		log.info("Is Accessories displayed? " + homePage.getAccessories().isDisplayed());
		homePage.getAccessories().click();
		log.info("Clicked on Accessories");
		reporter.childReport("STEP 2: Go to Product category and select Accessories");
		//verify the accessories title
		SeleniumUtility.presenceOfElement(driver,accessoriesPage.accessoriesHeader);
		
		log.info("STEP 3: Click on “Add to Cart” for just Magic Mouse");
		accessoriesPage.AddToCart(item, quantity);
		log.info("Added item: " + item + " x" + quantity);
		reporter.childReport("STEP 3: Click on “Add to Cart” for just Magic Mouse");
		
	
		log.info("STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page");
		reporter.childReport("STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page");
		log.info("waiting until the cart updates before continuing");
		SeleniumUtility.textToBePresentInElement(driver, accessoriesPage.getCartItemCount(), String.valueOf(accessoriesPage.getItemCount()));
		log.info("Number of items in cart: "+accessoriesPage.getCartItemCount().getText());
		accessoriesPage.getCheckout().click();
		log.info("Is the item in the cart with correct quantity? : " + cartPage.ConfirmItemInCart(item, quantity) );
		Assert.assertTrue(cartPage.ConfirmItemInCart(item, quantity));
		log.info("Confirmed: items are in cart");
		
		log.info("STEP 5: After confirming, click on Continue");
		cartPage.getContinue().click();
		log.info("clicked continue");
		reporter.childReport("STEP 5: After confirming, click on Continue");
		
		log.info("STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase");
		SeleniumUtility.visibilityOfElement(driver, checkout.getEmailAvatar());
		//if billing same as shipping address
		if(saba.equals("true")) {
			checkout.getEmail().sendKeys(email);
			log.info("entered email: " + email);
			checkout.getBillingFirstName().sendKeys(bfirstname);
			log.info("entered first name: " + bfirstname);
			checkout.getBillingLastName().sendKeys(blastname);
			log.info("entered last name: " + blastname);
			checkout.getBillingAddress().sendKeys(baddress);
			log.info("entered address: " + baddress);
			checkout.getBillingCity().sendKeys(bcity);
			log.info("entered city: " + bcity);
			checkout.getBillingState().sendKeys(bstate);
			log.info("entered state: " + bstate);
			checkout.getBillingCountry().selectByVisibleText(bcountry);
			log.info("entered country: " + bcountry);
			checkout.getBillPostalCode().sendKeys(bpostalcode);
			log.info("entered postal code: " + bpostalcode);
			checkout.getBillingphone().sendKeys(bphone);
			log.info("entered phone number: " + bphone);
			checkout.getSameAsBilling().click();
			log.info("Same as billing address(saba) = " + saba );
			checkout.getPurchase().click();
			log.info("Clicked purchase");
	
		} else {
			
			//if shipping address different
			
		}
		reporter.childReport("STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase");
		

		log.info("STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page");
		SeleniumUtility.presenceOfElement(driver,tr.transactionResultsHeader);
		log.info("Confirming Order...");
		Assert.assertTrue(tr.ConfirmTransaction());
		log.info(tr.getTitle());
		log.info("Confirmed: order placed!");
		reporter.childReport("STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page");
	}
		
	@DataProvider
	public Iterator<Object[]> getData(){
		
		ArrayList<Object[]> testData = ExcelUtility.getData();
		return testData.iterator();		
	}

}
