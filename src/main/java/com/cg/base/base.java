package com.cg.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cg.utilities.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;

	
	public  base() { 
		
		prop = new Properties();
	
		//File propFile = new File(System.getProperty("C:\\Users\\DSATRA\\eclipse-workspace\\TutorialsninjaProj\\src\\main\\java\\com\\cg\\config.configproperties"));
		
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cg\\config\\config.properties");
		
		dataprop= new Properties();
		File datapropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cg\\testdata\\testdata.properties");
		
		try {
		FileInputStream fis2= new FileInputStream(datapropFile);
		dataprop.load(fis2);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		try {
		FileInputStream fis  = new FileInputStream(propFile);
		prop.load(fis);
	}catch(Throwable e ) {
		e.printStackTrace();
	}
		
	}
	
	public WebDriver initializeBrowserAndOpenApp(String browsername) {
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("edge")) {
			//driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.Implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.Page_Wait_Time));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
}
