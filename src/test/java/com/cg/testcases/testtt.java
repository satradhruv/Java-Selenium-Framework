package com.cg.testcases;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class testtt {
	@Test
	public void testing() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://tutorialsninja.com/demo/");
	driver.findElement(By.linkText("iPhone")).click();
	//driver.quit();
	
	
	
	}
}
