package Loginpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	private By Username = By.id("email");
	private By Password = By.id("password");
	private By Signin = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(Username).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}

	public void signinbutton() {
		driver.findElement(Signin).click();

	}

	

}
