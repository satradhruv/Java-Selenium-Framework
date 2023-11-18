package com.cg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	private WebElement emailAddField;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private WebElement passField;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\\\"account-login\\\"]/div[1]")
	private WebElement emailPasswordNoMatch;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void enterEmailadd(String emailText) {
		emailAddField.sendKeys(emailText);
	}
	public void enterPassword(String passwordText) {
		passField.sendKeys(passwordText);
	}
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String retrieveEmailPassNotMAtching() {
		String WarningText = emailPasswordNoMatch.getText();
		return WarningText;
	}

}
