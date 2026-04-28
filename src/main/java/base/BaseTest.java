package base;

import java.time.Duration;

import config.ConfigReader;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		String browser = ConfigReader.get("browser");
		String url = ConfigReader.get("url");

		DriverFactory.initDriver(browser);

		DriverFactory.getDriver().get(url);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
