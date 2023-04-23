package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void validLogin() throws FilloException {
		Recordset rs=connection.executeQuery("select * from Data1 where TestName='positiveTest'");
		rs.next();
		String userName = rs.getField("Username");
		String passWord = rs.getField("Password");
		
		LoginPage login=new LoginPage(driver);
		login.LoginFunction(userName, passWord);
		
	}
	
	@Test
	public void invalidLogin() throws FilloException{
		Recordset rs=connection.executeQuery("select * from Data1 where TestName='negativeTest'");
		rs.next();
		String userName = rs.getField("Username");
		String passWord = rs.getField("Password");
		
		LoginPage login=new LoginPage(driver);
		login.LoginFunction(userName, passWord);
		WebElement error = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		
		String ActMsg = error.getText();
		String ExpMsg = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ActMsg, ExpMsg);
		
		
	}
}
