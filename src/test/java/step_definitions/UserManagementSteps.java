package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementSteps {
	
	CraterLoginPage craterLogin = new CraterLoginPage();
	CraterDashboardPage dashboard = new CraterDashboardPage();
	BrowserUtils utils = new BrowserUtils();

	
	//valid login test
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();

	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String useremail, String password) {
		utils.sendKeysWithActionsClass(craterLogin.useremail, useremail);
		utils.sendKeysWithActionsClass(craterLogin.password, password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		craterLogin.loginButton.click();

	}

	@Then("user should be navigated to the dashboard page")
	public void user_should_be_navigated_to_the_dashboard_page() {
		utils.waitUntilElementVisible(dashboard.amountDueText);
		Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	}
	
	@Then("user quits the browser")
	public void user_quits_the_browser() {
	    Driver.quitDriver();
	}

	
	
	// Invalid login steps
	boolean userEmailEmpty;
	boolean passwordEmpty;
	
	@When("user enters invalid useremail {string} and password {string}")
	public void user_enters_invalid_and(String invalidUserEmail, String invalidPassword) {
		userEmailEmpty = invalidUserEmail.isBlank();
		passwordEmpty = invalidPassword.isBlank();
		utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUserEmail);
		utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}

	//Invalid login scenario outline
	@Then("error messages appear")
	public void error_messages_appear() {
	    if(userEmailEmpty || passwordEmpty) {
	    	utils.waitUntilElementVisible(craterLogin.fieldRequired);
	    	Assert.assertTrue(craterLogin.fieldRequired.isDisplayed());   	
	    }
	    else {
	    	utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
	    	Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
	    }
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {
		Assert.assertEquals(TestDataReader.getProperty("craterUrl"), Driver.getDriver().getCurrentUrl());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	@Given("user navigates to Items tab")
	public void user_navigates_to_items_tab() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on the Add Item button")
	public void user_clicks_on_the_add_item_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user should be on item input page")
	public void user_should_be_on_item_input_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user provides item information “name” and “price” and “unit” and “description”")
	public void user_provides_item_information_name_and_price_and_unit_and_description() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("click Save Item button")
	public void click_save_item_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("selects the item “Books”")
	public void selects_the_item_books() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user should be on item details page")
	public void user_should_be_on_item_details_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user updates the item price to {int} dollars")
	public void user_updates_the_item_price_to_dollars(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("click Update Item button")
	public void click_update_item_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	
	

}
