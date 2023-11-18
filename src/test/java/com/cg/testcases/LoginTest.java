package com.cg.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cg.base.base;
import com.cg.pages.AccountPage;
import com.cg.pages.HomePage;
import com.cg.pages.LoginPage;
import com.cg.utilities.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends base{
	
	LoginPage loginpage;
	
	public LoginTest() {
		super();
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=initializeBrowserAndOpenApp(prop.getProperty("browser"));
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.SelectLoginOption();
//		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
//		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test (priority=1, dataProvider="validCredentialsSupplier")
	public void Logintestcase1(String email, String password) {
		
	
//		LoginPage loginpage = new LoginPage(driver);	
		loginpage.enterEmailadd(email);
		loginpage.enterPassword(password);
		AccountPage accountpage=loginpage.clickOnLoginButton();

		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
//		AccountPage accountpage = new AccountPage(driver);
		
		Assert.assertTrue(accountpage.getDisplayStatusOfEditInfo());
	//	Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit your account information option is not displayed");
		//driver.quit();
}
	@DataProvider(name= "validCredentialsSupplier" )
	public Object[][] supplytestdata() {
		Object[][] data = utilities.getdatafromExcel("LoginSheet");
		//Object[][] data = {{"satradhruv1809@gmail.com","password"}};
		return data;
		}
	 
	
	
	@Test (priority=2)
	public void Logintestcase2() {
		

//		LoginPage loginpage = new LoginPage(driver);	
		loginpage.enterEmailadd(utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(dataprop.getProperty("InvalidPassword"));
		loginpage.clickOnLoginButton();
				 
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(dataprop.getProperty("InvalidPassword"));
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		String actualWarningMessage= loginpage.retrieveEmailPassNotMAtching();
		String ExpectedWarningMessage= dataprop.getProperty("emailPasswordNoMatch");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage), "Expected warning is not displayed");
		
		
	}


}
