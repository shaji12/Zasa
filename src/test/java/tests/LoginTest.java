package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testvalidLogin() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickloginbutton();
		loginPage.enterUsername("arshadazadad@yahoo.com");
		loginPage.enterPassword("123456");
		loginPage.clickloginandSelectStudentbutton();

		System.out.println("Title of the page is " + driver.getTitle());
	}

}
