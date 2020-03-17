package com.cts.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cts.productstorepages.AddToCartPage;
import com.cts.productstorepages.CartInfoPage;
import com.cts.productstorepages.ContactInfoPage;
import com.cts.productstorepages.DeletePage;
import com.cts.productstorepages.LoginPage;
import com.cts.productstorepages.PlaceOrderPage;
import com.cts.productstorepages.ProductPage;
import com.cts.productstorepages.UserDetailPage;
import com.cts.productstorepages.signUpPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	WebDriver driver;

	@Given("I have browser with productstore page.")
	public void i_have_browser_with_productstore_page() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com");
	}

	@When("I enter username as {string} and I enter password as {string}")
	public void i_enter_username_as_and_I_enter_password_as(String userName, String password) {
		LoginPage.clickOnLogin(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginusername")));
		LoginPage.enterUserName(driver, userName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginpassword")));
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLoginAgain(driver);
	}

	@Then("I Should access to the portal with title as {string}")
	public void i_Should_access_to_the_portal_with_title_as(String expectedText) {
		String actualText = driver.findElement(By.linkText("Log out")).getText();
		Assert.assertEquals(actualText, expectedText);
		driver.quit();

	}

	@When("I enter valid username as {string} and password as {string}")
	public void i_enter_valid_username_as_and_password_as(String username, String Password) {
		LoginPage.clickOnLogin(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginusername")));
		LoginPage.enterUserName(driver, username);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginpassword")));
		LoginPage.enterPassword(driver, Password);
		LoginPage.clickOnLoginAgain(driver);
	}

	@Then("I should get error popup message as {string}")
	public void i_should_get_error_popup_message_as(String expectedAlertMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		String actualAlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		driver.quit();
	}

	@When("I  will not enter valid username as {string} and i will enter valid password as {string}")
	public void i_will_not_enter_valid_username_as_and_i_will_enter_valid_password_as(String emptyUserName,
			String password) {
		LoginPage.clickOnLogin(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginusername")));
		LoginPage.enterUserName(driver, emptyUserName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginpassword")));
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLoginAgain(driver);

	}

	@Then("I should get  popup message as {string}")
	public void i_should_get_popup_message_as(String expectedUserAlertMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		String actualUserAlretMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualUserAlretMessage, expectedUserAlertMessage);
		driver.quit();
	}

	@When("I enter valid username as {string} and i will not enter password  {string}")
	public void i_enter_valid_username_as_and_i_will_not_enter_password(String userName, String emptypassword) {
		LoginPage.clickOnLogin(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginusername")));
		LoginPage.enterUserName(driver, userName);
		LoginPage.enterPassword(driver, emptypassword);
		LoginPage.clickOnLoginAgain(driver);
	}

	@Then("I should get error popup message for empty password as {string}")
	public void i_should_get_error_popup_message_for_empty_password_as(String expectedPasswordAlertMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		String actualPasswordAlretMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualPasswordAlretMessage, expectedPasswordAlertMessage);
		driver.quit();
	}

	@When("I enter valid recepeintEmail as {string} and recepientName as {string} and message as {string}")
	public void i_enter_valid_recepeintEmail_as_and_recepientName_as_and_message_as(String recepientMailId,
			String recepientName, String Message) {
		ContactInfoPage.clickOnContact(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("recipient-email")));
		ContactInfoPage.enterRecepientMailId(driver, recepientMailId);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("recipient-name")));
		ContactInfoPage.enterRecepientName(driver, recepientName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message-text")));
		ContactInfoPage.enterMessage(driver, Message);
		ContactInfoPage.clickOnMessage(driver);
	}

	@Then("I should get complete contact filling popup message as {string}")
	public void i_should_get_complete_contact_filling_popup_message_as(String expectedContactFillingAlertMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.alertIsPresent());
		String actualContactFillingAlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualContactFillingAlertMessage, expectedContactFillingAlertMessage);
		driver.quit();
	}

	@When("I will not enter valid recepientEmail as {string} and recepientName as {string} and message as {string}")
	public void i_will_not_enter_valid_recepientEmail_as_and_recepientName_as_and_message_as(String recepientMailId,
			String recepientName, String Message) {
		ContactInfoPage.clickOnContact(driver);
		ContactInfoPage.enterRecepientMailId(driver, recepientMailId);
		ContactInfoPage.enterRecepientName(driver, recepientName);
		ContactInfoPage.enterMessage(driver, Message);
		ContactInfoPage.clickOnMessage(driver);
	}

	@Then("I should get popup message without filling details as {string}")
	public void i_should_get_popup_message_without_filling_details_as(
			String expectedWithoutContactFillingAlertMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.alertIsPresent());
		String actualWithoutContactFillingAlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualWithoutContactFillingAlertMessage, expectedWithoutContactFillingAlertMessage);
		driver.quit();
	}

	@When("I click on the product in home page and click on add to cart")
	public void i_click_on_the_product_in_home_page_and_click_on_add_to_cart() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
		LoginPage.clickOnHomePage(driver);

		// wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//img[@src='imgs/galaxy_s6.jpg']"))));
		ProductPage.clickOnProduct(driver);
		AddToCartPage.clickProductToAddToCart(driver);
		AddToCartPage.clickOnAddToCart(driver);
	}

	@Then("I should get a popup message as {string}")
	public void i_should_get_a_popup_message_as(String expectedAddToCartAlertMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.alertIsPresent());
		String actualAddToCartAlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAddToCartAlertMessage, expectedAddToCartAlertMessage);
		AddToCartPage.clickOnAlert(driver);
		driver.quit();
	}

	
	@When("I click on delete")
	public void i_click_on_delete() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
		LoginPage.clickOnHomePage(driver);
		ProductPage.clickOnProduct(driver);
		AddToCartPage.clickProductToAddToCart(driver);
		AddToCartPage.clickOnAddToCart(driver);
		wait.until(ExpectedConditions.alertIsPresent());
		AddToCartPage.clickOnAlert(driver);
		CartInfoPage.clickOnCart(driver);
		DeletePage.clickOnDelete(driver);
	}

	@Then("The product should be deleted")
	public void the_product_should_be_deleted() {
		String total = driver.findElement(By.xpath("//h3[text()='360']")).getText();
		int Total = Integer.parseInt(total);
		if (Total < 0) {
			Assert.fail("Does not meet my requirements");
		} else {
			System.out.println("passed");
		}
	}
	@When("I click on place order")
	public void i_click_on_place_order() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
		LoginPage.clickOnHomePage(driver);
		ProductPage.clickOnProduct(driver);
		AddToCartPage.clickProductToAddToCart(driver);
		AddToCartPage.clickOnAddToCart(driver);
		wait.until(ExpectedConditions.alertIsPresent());
		AddToCartPage.clickOnAlert(driver);
		CartInfoPage.clickOnCart(driver);
		PlaceOrderPage.clickOnPlaceOrder(driver);
	}

	@Then("it should display form for filling details")
	public void it_should_display_form_for_filling_details() throws InterruptedException {
	    
		String actualText=driver.findElement(By.xpath("//span[text()='×']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(actualText, "");
		driver.quit();
	}
	@When("I enter name as {string} and country as {string} and city as {string} and credit card as {string} and month as {string} and year as {string} and click on purchase order")
	public void i_enter_my_name_as_and_country_as_and_city_as_and_credit_card_as_and_month_as_and_year_as_and_click_on_purchase_order(String name, String country, String city, String creditCard, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
		LoginPage.clickOnHomePage(driver);
		ProductPage.clickOnProduct(driver);
		AddToCartPage.clickProductToAddToCart(driver);
		AddToCartPage.clickOnAddToCart(driver);
		wait.until(ExpectedConditions.alertIsPresent());
		AddToCartPage.clickOnAlert(driver);
		CartInfoPage.clickOnCart(driver);
		PlaceOrderPage.clickOnPlaceOrder(driver);
		UserDetailPage.enterName(driver, name);
		UserDetailPage.enterCountry(driver, country);
		UserDetailPage.enterCity(driver, city);
		UserDetailPage.enterCreditCard(driver, creditCard);
		UserDetailPage.enterMonth(driver, month);
		UserDetailPage.enterYear(driver, year);
		UserDetailPage.clickOnPurchase(driver);
	}

	@Then("It should display purchase details popup message as {string}")
	public void it_should_display_purchase_details_popup_message_as(String expectedText) {
	 String actualText=driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();
	 Assert.assertEquals(actualText, expectedText);
	 driver.quit();
	}
	@When("I enter the name as {string} and country as {string} and city as {string} and credit card as {string} and month as {string} and year as {string} and click on purchase order")
	public void i_enter_the_name_as_and_country_as_and_city_as_and_credit_card_as_and_month_as_and_year_as_and_click_on_purchase_order(String name, String country, String city, String creditCard, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
		LoginPage.clickOnHomePage(driver);
		ProductPage.clickOnProduct(driver);
		AddToCartPage.clickProductToAddToCart(driver);
		AddToCartPage.clickOnAddToCart(driver);
		wait.until(ExpectedConditions.alertIsPresent());
		AddToCartPage.clickOnAlert(driver);
		CartInfoPage.clickOnCart(driver);
		PlaceOrderPage.clickOnPlaceOrder(driver);
		UserDetailPage.enterName(driver, name);
		UserDetailPage.enterCountry(driver, country);
		UserDetailPage.enterCity(driver, city);
		UserDetailPage.enterCreditCard(driver, creditCard);
		UserDetailPage.enterMonth(driver, month);
		UserDetailPage.enterYear(driver, year);
		UserDetailPage.clickOnPurchase(driver);
	}

	@Then("It should display a popup message as {string}")
	public void it_should_display_a_popup_message_as(String expectedMissingdetailsText) {
	   String actualMissingdetailsText=driver.switchTo().alert().getText();
	   Assert.assertEquals(actualMissingdetailsText, expectedMissingdetailsText);
	   driver.quit();
	}
	@When("I enter the name in purchase detail as {string} and country as {string} and city as {string} and credit card as {string} and month as {string} and year as {string} and click on purchase order and click on close")
	public void i_enter_the_name_in_purchase_detail__as_and_country_as_and_city_as_and_credit_card_as_and_month_as_and_year_as_and_click_on_purchase_order_and_click_on_close(String name, String country, String city, String creditCard, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
		LoginPage.clickOnHomePage(driver);
		ProductPage.clickOnProduct(driver);
		AddToCartPage.clickProductToAddToCart(driver);
		AddToCartPage.clickOnAddToCart(driver);
		wait.until(ExpectedConditions.alertIsPresent());
		AddToCartPage.clickOnAlert(driver);
		CartInfoPage.clickOnCart(driver);
		PlaceOrderPage.clickOnPlaceOrder(driver);
		UserDetailPage.enterName(driver, name);
		UserDetailPage.enterCountry(driver, country);
		UserDetailPage.enterCity(driver, city);
		UserDetailPage.enterCreditCard(driver, creditCard);
		UserDetailPage.enterMonth(driver, month);
		UserDetailPage.enterYear(driver, year);
		UserDetailPage.clickOnPurchase(driver);
		UserDetailPage.clickOnOk(driver);
	}

	@Then("Check for home page")
	public void check_for_home_page() {
	   String actualTextInHomeIcon =driver.findElement(By.partialLinkText("PRODUCT STORE")).getText();
	   Assert.assertEquals(actualTextInHomeIcon,"PRODUCT STORE");
	   driver.quit();
	}
	@When("I enter the useer name as {string} and country as {string} and city as {string} and credit card as {string} and month as {string} and year as {string} and click on purchase order and click on close button")
	public void i_enter_the_useer_name_as_and_country_as_and_city_as_and_credit_card_as_and_month_as_and_year_as_and_click_on_purchase_order_and_click_on_close_button(String name, String country, String city, String creditCard, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
		LoginPage.clickOnHomePage(driver);
		ProductPage.clickOnProduct(driver);
		AddToCartPage.clickProductToAddToCart(driver);
		AddToCartPage.clickOnAddToCart(driver);
		wait.until(ExpectedConditions.alertIsPresent());
		AddToCartPage.clickOnAlert(driver);
		CartInfoPage.clickOnCart(driver);
		PlaceOrderPage.clickOnPlaceOrder(driver);
		UserDetailPage.enterName(driver, name);
		UserDetailPage.enterCountry(driver, country);
		UserDetailPage.enterCity(driver, city);
		UserDetailPage.enterCreditCard(driver, creditCard);
		UserDetailPage.enterMonth(driver, month);
		UserDetailPage.enterYear(driver, year);
		UserDetailPage.clickOnClose(driver);
	}

	@Then("It should go back to the cartpage and assert for {string}")
	public void it_should_go_back_to_the_cartpage_and_assert_for(String expectedTextInHomeIcon) {
		String actualTextInHomeIcon1 =driver.findElement(By.partialLinkText("PRODUCT STORE")).getText();
		   Assert.assertEquals(actualTextInHomeIcon1,expectedTextInHomeIcon);
		   driver.quit();
	}
	@When("I enter username as {string} and Password as {string}")
	public void i_enter_username_as_and_Password_as(String userName, String password) {
	    signUpPage.clickOnSignUp(driver);
	    
	    signUpPage.enterUserName(driver, userName);
	    signUpPage.enterPassword(driver, password);
	}

	@Then("I should click on signUp")
	public void i_should_click_on_signUp() {
	   signUpPage.againClickOnSignUp(driver);
	   WebDriverWait wait = new WebDriverWait(driver, 30);
	   wait.until(ExpectedConditions.alertIsPresent());
	   String signUpSuccessfullyaActualText= driver.switchTo().alert().getText();
		Assert.assertEquals(signUpSuccessfullyaActualText, "Sign up successful.");
		driver.switchTo().alert().accept();
		driver.quit();
	}
	@When("I enter the already used username as {string} and password as {string}")
	public void i_enter_the_already_used_username_as_and_password_as(String userName, String password) {
		 signUpPage.clickOnSignUp(driver);
		    signUpPage.enterUserName(driver, userName);
		    signUpPage.enterPassword(driver, password);
	}

	@Then("I should click on signup and I should get popup message as {string}")
	public void i_should_click_on_signup_and_I_should_get_popup_message_as(String signUpSuccessfullyExpectedText) {
		   signUpPage.againClickOnSignUp(driver);
		   WebDriverWait wait = new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.alertIsPresent());
		   String signUpSuccessfullyaActualText= driver.switchTo().alert().getText();
			Assert.assertEquals(signUpSuccessfullyaActualText, signUpSuccessfullyExpectedText);
			driver.switchTo().alert().accept();
			driver.quit();
	}
	@When("I will not enter the username {string} and i will not enter the password {string}")
	public void i_will_not_enter_the_username_and_i_will_not_enter_the_password(String userName, String password) {
		signUpPage.clickOnSignUp(driver);
	    
	    signUpPage.enterUserName(driver, userName);
	    signUpPage.enterPassword(driver, password);
	}

	@Then("I should click on signup and I should get the popup message as {string}")
	public void i_should_click_on_signup_and_I_should_get_the_popup_message_as(String signUpSuccessfullyExpectedText) {
		signUpPage.againClickOnSignUp(driver);
		   WebDriverWait wait = new WebDriverWait(driver, 30);
		   wait.until(ExpectedConditions.alertIsPresent());
		   String signUpSuccessfullyaActualText= driver.switchTo().alert().getText();
			Assert.assertEquals(signUpSuccessfullyaActualText, signUpSuccessfullyExpectedText);
			driver.switchTo().alert().accept();
			driver.quit();
	}
	@When("I click on mobile phones it will show only mobile phones")
	public void i_click_on_mobile_phones_it_will_show_only_mobile_phones() {
	    driver.findElement(By.linkText("Phones")).click();
	}

	@Then("I search for mobile phone visibility for assertion")
	public void i_search_for_mobile_phone_visibility_for_assertion() {
		String actualText=driver.findElement(By.xpath("//img[@src='imgs/galaxy_s6.jpg']/ancestor::a")).getText();
		Assert.assertEquals(actualText, "");
		driver.quit();
		
	}
	@When("I click on laptops it will show only Laptops")
	public void i_click_on_laptops_it_will_show_only_Laptops() {
		  driver.findElement(By.linkText("Laptops")).click();
	}

	@Then("I search for laptops visibility for assertion")
	public void i_search_for_laptops_visibility_for_assertion() {
		String actualText=driver.findElement(By.xpath("//img[@src='imgs/sony_vaio_5.jpg']/ancestor::a")).getText();
		Assert.assertEquals(actualText, "");
		driver.quit();
	}

	@When("I click on monitors it will show only monitors")
	public void i_click_on_monitors_it_will_show_only_monitors() {
		  driver.findElement(By.linkText("Monitors")).click();
	}

	@Then("I search for monitors visibility for assertion")
	public void i_search_for_monitors_visibility_for_assertion() {
		String actualText=driver.findElement(By.xpath("//img[@src='imgs/asusm.jpg']/ancestor::a")).getText();
		Assert.assertEquals(actualText, "");
		driver.quit();
	}


}
