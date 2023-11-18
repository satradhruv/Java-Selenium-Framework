package com.cg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(linkText="iMac")
	private WebElement  validProduct;
	
	@FindBy(xpath="/*[@id=\\\"content\\\"]/p[2]")
	private WebElement noProductMessage;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	public String retrieveNoProductMessage() {
		String noProductText= noProductMessage.getText();
		return noProductText;
	}
	
	public boolean displayStatusOfProduct() {
		boolean displayStatus= validProduct.isDisplayed();
		return displayStatus;
	}
}
