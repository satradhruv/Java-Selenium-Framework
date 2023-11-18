package com.cg.testcases;


import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cg.base.base;
import com.cg.pages.HomePage;
import com.cg.pages.RegisterPage;
import com.cg.utilities.utilities;

import org.testng.annotations.BeforeMethod;



import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest extends base{
	WebDriver driver;
	RegisterPage registerPage;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver= initializeBrowserAndOpenApp(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerPage= homepage.selectRegisterOption();
		
//		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
//		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	@Test(priority =1)
	public void Registertest1() {
//		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstname"));
		registerPage.enterLastName(dataprop.getProperty("lastname"));
		registerPage.enterEmailAdd(utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.selectPrivacyPolicy();
		registerPage.ClickOnContinue();
	
		
//		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys(dataprop.getProperty("firstname"));
//		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(dataprop.getProperty("lastname"));
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(dataprop.getProperty("telephone"));
//		
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(prop.getProperty("ValidPassword"));
//		driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(prop.getProperty("ValidPassword"));
//		
		//driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
//		
//		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		String actualheading = registerPage.AccountCreated() ;
		//String actualheading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualheading,"Your Account Has Been Created!","Account cannot be created" );
		
		
	}
	
	@Test(priority =2)
	public void RegisterTest2() {
//		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstname"));
		registerPage.enterLastName(dataprop.getProperty("lastname"));
		registerPage.enterEmailAdd(prop.getProperty("ValidEmail"));
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.selectPrivacyPolicy();
		registerPage.ClickOnContinue();
		String actualheading = registerPage.AccountCreated() ;
		Assert.assertEquals(actualheading,"Your Account Has Been Created!","Account cannot be created" );
	
		
//		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys(dataprop.getProperty("firstname"));
//		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(dataprop.getProperty("lastname"));
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(prop.getProperty("ValidEmail"));
//		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(dataprop.getProperty("telephone"));
//		
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(prop.getProperty("ValidPassword"));
//		driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(prop.getProperty("ValidPassword"));
//		
//		//driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
//		
//		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
//		
//		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
	
		//String actualWarning = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		//Assert.assertTrue(actualWarning.contains(" Warning: E-Mail Address is already registered!"),"Warning message is not displayed");
		
		
	}
	
	

}
