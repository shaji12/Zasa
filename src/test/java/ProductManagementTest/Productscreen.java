package ProductManagementTest;

import factory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Loginpages.LoginPage;
import ProductManagement.Product;
import base.BaseTest;

public class Productscreen extends BaseTest {

    @Test
    public void addEditProductTest() {

        // Login
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterUsername("ajay@store.com");
        loginPage.enterPassword("123456");
        loginPage.signinbutton();

        // Product Page
        Product productPage = new Product(DriverFactory.getDriver());

        // Navigate to Product Screen
        productPage.productmanagementdrop();
        productPage.clickproductsidemenu();

        // Add Product
        try {
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
            //String expectedMessage = "Product added successfully.";

            Assert.assertEquals(actualMessage, "Product added successfully.");
            System.out.println("Add Product Success");
        } catch (Exception e){
            System.out.println("Add product Failed: " + e.getMessage() );
            e.printStackTrace();
            Assert.fail("Add product Failed");
        }

        // ================= EDIT PRODUCT =================
        try {
            productPage.searchProduct("Nike Green");
            productPage.openEditMenu();
            productPage.changeProductName("Test Automation Product");
            productPage.clickSaveButton();
            String actualMessages = productPage.getupdatedsucess();
            //String expectedMessages = "Product updated successfully.";

            Assert.assertEquals(actualMessages, "Product updated successfully.");
            System.out.println("EDIT PRODUCT SUCCESS");
        }catch (Exception e){
            System.out.println("EDIT PRODUCT FAILED:"+ e.getMessage());
            e.printStackTrace();
            Assert.fail("EDIT PRODUCT FAILED");
        }

        // Delete Product
        try {
            productPage.searchProducts("Test Automation Produ");
            productPage.deleteproduct();
            String deleteactualMessage = productPage.deletedsuccess();
            //String deleteexpectedMessage = "Product deleted successfully.";
            Assert.assertEquals(deleteactualMessage, "Product deleted successfully.");
            System.out.println("DELETE PRODUCT SUCCESS");
        }catch (Exception e){
            System.out.println("EDIT PRODUCT FAILED:"+ e.getMessage());
            e.printStackTrace();
            Assert.fail("EDIT PRODUCT FAILED");
        }


    }
}