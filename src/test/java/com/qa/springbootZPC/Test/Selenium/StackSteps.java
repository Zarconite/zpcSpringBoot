package com.qa.springbootZPC.Test.Selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.springbootZPC.Test.Selenium.Pages.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {

	WebElement element;
	WebDriver driver;
	String searchQuery;
	
	
	@Before
	public void startup() {
		stackTest.test = stackTest.report.startTest("Verify scenarios..");
	}
	
	@Given("^I log into an admin account$")
	public void i_log_into_an_admin_account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I navigate to the add a part form$")
	public void i_navigate_to_the_add_a_part_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click the part \"([^\"]*)\" type dropdown menu$")
	public void i_click_the_part_type_dropdown_menu(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" brand$")
	public void i_fill_out_the_brand(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" model$")
	public void i_fill_out_the_model(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" name$")
	public void i_fill_out_the_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" outputs$")
	public void i_fill_out_the_outputs(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" inputs$")
	public void i_fill_out_the_inputs(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out if the part is \"([^\"]*)\" overclockable$")
	public void i_fill_out_if_the_part_is_overclockable(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" extra information$")
	public void i_fill_out_the_extra_information(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" base clock$")
	public void i_fill_out_the_base_clock(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" boost clock$")
	public void i_fill_out_the_boost_clock(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" price$")
	public void i_fill_out_the_price(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I fill out the \"([^\"]*)\" count$")
	public void i_fill_out_the_count(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the new part will be added to the database$")
	public void the_new_part_will_be_added_to_the_database() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^I navigate to the parts list$")
	public void i_navigate_to_the_parts_list() throws Throwable {
		stackTest.driver.get(Constants.LANDINGPAGE);
		stackTest.test.log(LogStatus.INFO, "Chrome started..");
		stackTest.test.log(LogStatus.INFO, "Loading the landing page..");
		stackTest.test.log(LogStatus.INFO, "Navigating to the parts list..");
		LandingPage landingPage = PageFactory.initElements(stackTest.driver, LandingPage.class);
		landingPage.viewCoolers();
		stackTest.test.log(LogStatus.INFO, "Navigation complete!");
	}

	@When("^I navigate to the About us page$")
	public void i_navigate_to_the_About_us_page() throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Navigating to the about page..");
		LandingPage landingPage = PageFactory.initElements(stackTest.driver, LandingPage.class);
		landingPage.viewAboutUsPage();
		stackTest.test.log(LogStatus.INFO, "Navigation complete!");
	}

	@Then("^I can view the companies contact details$")
	public void i_can_view_the_companies_contact_details() throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Checking the result..");
		LandingPage landingPage = PageFactory.initElements(stackTest.driver, LandingPage.class);
		String ResultString = landingPage.viewAboutUsInfo(stackTest.driver);
		
		if(ResultString.equals("About us")) {
			stackTest.test.log(LogStatus.PASS, "Result should return 'About us' | Expected: " + "About us" + " | Actual: " + ResultString);
		}
		else {
			stackTest.test.log(LogStatus.FAIL, "Result should return 'About us' | Expected: " + "About us" + " | Actual: " + ResultString);
		}
		assertEquals("Result should return 'About us'", "About us", ResultString);
	}

	@Given("^I click on the search bar$")
	public void i_click_on_the_search_bar() throws Throwable {
		stackTest.driver.get(Constants.LANDINGPAGE);
		stackTest.test.log(LogStatus.INFO, "Chrome started..");
		stackTest.test.log(LogStatus.INFO, "Loading the landing page..");
		stackTest.test.log(LogStatus.INFO, "Clicking the searchbox..");
		LandingPage landingPage = PageFactory.initElements(stackTest.driver, LandingPage.class);
		landingPage.searchboxSelect();
		stackTest.test.log(LogStatus.INFO, "Complete!");
	}

	@When("^I search for a part \"([^\"]*)\"$")
	public void i_search_for_a_part(String partName) throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Searching for part..");
		LandingPage landingPage = PageFactory.initElements(stackTest.driver, LandingPage.class);
		landingPage.searchFor(partName);
		stackTest.test.log(LogStatus.INFO, "Searching complete!");
	}

	@When("^add it to the basket$")
	public void add_it_to_the_basket() throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Adding part to basket..");
		PartsPage partsPage = PageFactory.initElements(stackTest.driver, PartsPage.class);
		partsPage.addToBasket();
		stackTest.test.log(LogStatus.INFO, "Basket add complete!");
	}

	@When("^I search for another part \"([^\"]*)\"$")
	public void i_search_for_another_part(String partName2) throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Searching for part..");
		LandingPage landingPage = PageFactory.initElements(stackTest.driver, LandingPage.class);
		landingPage.searchFor(partName2);
		stackTest.test.log(LogStatus.INFO, "Searching complete!");
	}

	@When("^I add that part to the basket$")
	public void i_add_that_part_to_the_basket() throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Adding part to basket..");
		PartsPage partsPage = PageFactory.initElements(stackTest.driver, PartsPage.class);
		partsPage.addToBasket();
		stackTest.test.log(LogStatus.INFO, "Basket add complete!");
	}

	@Then("^I the basket should display both parts$")
	public void i_the_basket_should_display_both_parts() throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Checking the result..");
		BasketPage basketPage = PageFactory.initElements(stackTest.driver, BasketPage.class);
		basketPage.viewBasket();
		String part1Result = basketPage.checkBasketItem1();
		String part2Result = basketPage.checkBasketItem2();
		
		if(part1Result != null && part2Result != null) {
			stackTest.test.log(LogStatus.PASS, "Result should not be null | Expected: Not null | Actual: Not null");
		}
		else {
			stackTest.test.log(LogStatus.FAIL, "Result should not be null | Expected: Not null | Actual: null");
		}
		assertNotNull("Result should not be null", part1Result);
		assertNotNull("Result should not be null", part2Result);
		
	}

	@Then("^show the correct price$")
	public void show_the_correct_price() throws Throwable {
		stackTest.test.log(LogStatus.INFO, "Checking the result..");
		BasketPage basketPage = PageFactory.initElements(stackTest.driver, BasketPage.class);
		Double priceResult1 = basketPage.checkBasketItem1Price();
		Double priceResult2 = basketPage.checkBasketItem2Price();
		Double priceResultTotal = basketPage.checkBasketPrice();
		Double actualResult = priceResult1+priceResult2;
		
		if(priceResult1+priceResult2==priceResultTotal) {
			stackTest.test.log(LogStatus.PASS, "Result should return the correct price | Expected: £" + priceResultTotal + " | Actual: £" + actualResult);
		}
		else {
			stackTest.test.log(LogStatus.FAIL, "Result should return the correct price | Expected: £" + priceResultTotal + " | Actual: £" + actualResult);
		}
		assertEquals("Result should return the correct price", priceResultTotal, actualResult);
	}

	@When("^I type in a part name \"([^\"]*)\"$")
	public void i_type_in_a_part_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should only see relevant search results$")
	public void i_should_only_see_relevant_search_results() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I view a product$")
	public void i_view_a_product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should be able to see if the part is in stock or not$")
	public void i_should_be_able_to_see_if_the_part_is_in_stock_or_not() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^I navigate to the pc builder$")
	public void i_navigate_to_the_pc_builder() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I select automatic$")
	public void i_select_automatic() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I input my max price$")
	public void i_input_my_max_price() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I select Balanced performance$")
	public void i_select_Balanced_performance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click accept$")
	public void i_click_accept() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should be presented with a fully compatible build below my max price$")
	public void i_should_be_presented_with_a_fully_compatible_build_below_my_max_price() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
}
