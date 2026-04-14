package tests;

import org.testng.annotations.Test;

import Loginpages.LoginPage;
import base.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void testvalidLogin() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("ajay@store.com");
		loginPage.enterPassword("123456");
		loginPage.signinbutton();

		System.out.println("Title of the page is " + driver.getTitle());
	}

}

//✅ ThreadLocal (parallel-safe)
//✅ POM (Page Object Model)
//✅ TestNG Listener (logs + screenshots)
//✅ ExtentReports (full integration)
//✅ Retry Analyzer
//✅ CI/CD ready (Maven + Jenkins compatible structure)
