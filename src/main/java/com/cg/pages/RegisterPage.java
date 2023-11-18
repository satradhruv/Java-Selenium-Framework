package com.cg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	private WebElement firstnameField;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	private WebElement LastnameField;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	private WebElement EmailaddField;
	 
	@FindBy(xpath="//*[@id=\"input-telephone\"]" )
	private WebElement telephoneField;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private WebElement PasswordField;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	private WebElement PassConfirmField;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement ContinueButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	private WebElement AccountCreatedSuccessfully;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void enterFirstName(String firstnameText) {
		firstnameField.sendKeys("firstnameText");
	}
	public void enterLastName(String lastnameText) {
		LastnameField.sendKeys("firstnameText");
	}
	public void enterEmailAdd(String EmailAdd) {
		EmailaddField.sendKeys("EmailAdd");
	}
	
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys("telephone");
	}
	public void enterPassword(String Password) {
		PasswordField.sendKeys("Password");
	}
	public void enterConfirmPassword(String ConfPass) {
		PassConfirmField.sendKeys("ConfPass");
	}
	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}
	public void ClickOnContinue() {
		ContinueButton.click();
	
	}
	
	//5:30
	public String AccountCreated() {
		String Accountcreatedtext= AccountCreatedSuccessfully.getText();
		return Accountcreatedtext;
	}
	
}
