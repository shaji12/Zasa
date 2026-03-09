package ProductManagementTest;
 
import org.testng.Assert;

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
 
		AddProduct.clickAddProduct();

		AddProduct.enterProductName("Nike Green");

		AddProduct.selectCategory();

		AddProduct.enterDescription("Tested");

		AddProduct.selectBrand();

		AddProduct.selectItemType();

		AddProduct.selectItemSize();

		AddProduct.selectGender();

		AddProduct.selectStockCategory();

		AddProduct.selectGrade();

		AddProduct.enterPurchasePrice("21");

		AddProduct.enterSellingPrice("25");

		AddProduct.selectInstitution();

		AddProduct.clickSubmit();

		String actual = AddProduct.getSuccessMessage();

		String expected = "Product added successfully.";

		Assert.assertEquals(actual, expected);

		//AddProduct.deleteProduct("nike");
 
		

	}
 
}

 