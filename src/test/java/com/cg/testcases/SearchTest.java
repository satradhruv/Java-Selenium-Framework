package com.cg.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cg.base.base;
import com.cg.pages.HomePage;
import com.cg.pages.SearchPage;
//import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class SearchTest extends base{
	SearchPage searchpage;
	WebDriver driver;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApp(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchtest1(){
		HomePage homepage = new HomePage(driver);
		homepage.EnterProductName(dataprop.getProperty("validproduct"));
		searchpage=homepage.clickOnSearchButton();
//		SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.displayStatusOfProduct(),"Valid product");
		
		
		
//		driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("validproduct"));
//		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("iMac")).isDisplayed());
		
	}
	@Test(priority = 2)
	public void searchtest2() {
		HomePage homepage = new HomePage(driver);
		homepage.EnterProductName(dataprop.getProperty("invalidproduct"));
		searchpage=homepage.clickOnSearchButton();
//		SearchPage searchpage = new SearchPage(driver);
		String actualSearchMessage = searchpage.retrieveNoProductMessage();
		Assert.assertEquals(actualSearchMessage,dataprop.getProperty(actualSearchMessage));
		//Assert.assertEquals(actualSearchMessage,dataprop.getProperty(actualSearchMessage));
		//6:00
		
		
//		driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("invalidproduct"));
//		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).isDisplayed());
		//2:55
		
	}

}
