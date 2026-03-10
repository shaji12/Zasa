package ProductManagementTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Loginpages.LoginPage;
import ProductManagement.Product;
import base.BaseTest;

public class Productscreen extends BaseTest {

    @Test
    public void addEditProductTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("ajay@store.com");
        loginPage.enterPassword("123456");
        loginPage.signinbutton();

        // Product Page
        Product productPage = new Product(driver);

        // Navigate to Product Screen
        productPage.productmanagementdrop();
        productPage.clickproductsidemenu();

        // Add Product
        productPage.clickAddProduct();
        productPage.enterProductName("Nike Green");
        productPage.selectCategory();
        productPage.enterDescription("Tested");
        productPage.selectBrand();
        productPage.selectItemType();
        productPage.selectItemSize();
        productPage.selectGender();
        productPage.selectStockCategory();
        productPage.selectGrade();
        productPage.enterPurchasePrice("21");
        productPage.enterSellingPrice("25");
        productPage.selectInstitution();
        productPage.clickSubmit();

        // Validate Success Message
        String actualMessage = productPage.getSuccessMessage();
        String expectedMessage = "Product added successfully.";

        Assert.assertEquals(actualMessage, expectedMessage, "Product creation failed!");

        // Edit Product
        productPage.searchProduct("Nike Green");
        productPage.openEditMenu();
        productPage.changeProductName("Test Automation Product");
        productPage.clickSaveButton();
        String actualMessages = productPage.getupdatedsucess();
        String expectedMessages = "Product updated successfully.";
        
        Assert.assertEquals(actualMessages, expectedMessages);

        // Delete Product
        productPage.searchProducts("Test Automation Product");
        productPage.deleteproduct();
        String deleteactualMessage = productPage.deletedsuccess();
        String deleteexpectedMessage = "Product deleted successfully.";
        Assert.assertEquals(deleteactualMessage, deleteexpectedMessage);


    }
}