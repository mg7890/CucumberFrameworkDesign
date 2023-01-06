package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class amazonSearchSteps {
	
	AmazonHomePage homepage = new AmazonHomePage();
	AmazonSearchResultsPage resultsPage = new AmazonSearchResultsPage();
	BrowserUtils utils = new BrowserUtils();
	
	
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
		Driver.getDriver().get(TestDataReader.getProperty("amazonUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
	}

	@When("I enter the search term {string}")
	public void i_enter_the_search_term(String item) {
		utils.sendKeysWithActionsClass(homepage.searchInputField, item);
		
	}
	
	

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		homepage.searchButton.click();	
	}

	
	@Then("I should see the search item {string} on search results page")
	public void i_should_see_the_search_item_on_search_results_page(String item) {
		String result = resultsPage.itemSearchResultText.getText();
		String refinedResult = result.substring(1,result.length()-1);
//		System.out.println("Original result is: " + result);
//		System.out.println("Refined result is: " + refinedResult);
//		System.out.println("Expected value is: " + item);
		Assert.assertEquals(item, refinedResult);
		

	}
	
	@Then("the page title should contain the searched item {string}")
	public void the_page_title_should_contain_the_searched_item(String item) {
		String title = Driver.getDriver().getTitle();
		String output = title.substring(title.length()-item.length());
		Assert.assertEquals(item, output);
	}
	

}
