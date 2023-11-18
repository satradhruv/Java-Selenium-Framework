package com.cg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	
	//Objects
	@FindBy(xpath ="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	private WebElement myAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement LoginOption;
	
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//*[@id=\\\"search\\\"]/span/button")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Actions
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public void EnterProductName(String productText) {
		searchBoxField.sendKeys(productText);
		
	}
	
	public void clickOnMyAccount() {
		myAccount.click();
		
		
		
	}
	public LoginPage SelectLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
}
