package ProductManagementTest;

import org.testng.annotations.Test;

import Loginpages.LoginPage;
import ProductManagement.Product;
import base.BaseTest;

public class Productscreen extends BaseTest{
	
	@Test
	public void Addproduct() {
		
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("ajay@store.com");
		loginPage.enterPassword("123456");
		loginPage.signinbutton();

		Product AddProduct = new Product(driver);
		AddProduct.productmanagementdrop();
		AddProduct.clickproductsidemenu();
		
	}

}
