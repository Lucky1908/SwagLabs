package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(name="login-button")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
PageFactory.initElements(driver,this);
	}

public void LoginFunction(String UsernameVal, String PasswordVal) {
	userName.sendKeys(UsernameVal);
	passWord.sendKeys(PasswordVal);
	loginBtn.click();
	
}
	}


