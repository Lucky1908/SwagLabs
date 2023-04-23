package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;

	Fillo fillo;
	Connection connection;
	
	@BeforeTest
	public void filloSetup() throws FilloException {
		fillo=new Fillo();
		connection=fillo.getConnection("DataSheet.xlsx");
	}
		
		@BeforeMethod
		public void SetUp() {
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			
		}
		
			
		}	
		
	
	

