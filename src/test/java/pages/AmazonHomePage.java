package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class AmazonHomePage {
	
	public AmazonHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	public WebElement searchInputField;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	public WebElement searchButton;
	

}
