package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	private By Loginbutton = By.xpath("//button[text()='Login']");
	private By usernametextbox = By.name("signinEmail");
	private By passwordnametextbox = By.name("signinPassword");
	private By LoginandSelectStudentbutton = By.xpath("//button[normalize-space()='Login and Select Student']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickloginbutton() {
		driver.findElement(Loginbutton).click();
	}
	public void enterUsername(String username) {
		driver.findElement(usernametextbox).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordnametextbox).sendKeys(password);
	}

	public void clickloginandSelectStudentbutton() {
		driver.findElement(LoginandSelectStudentbutton).click();

	}

}
