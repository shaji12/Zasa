package ProductManagementTest;

import Loginpages.LoginPage;
import ProductManagement.ProductBarcodeManagement;
import base.BaseTest;
import factory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductBarcodeManagementscreen extends BaseTest {

    @Test
    public void productBarcodeManagement(){
        // Login
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterUsername("ajay@store.com");
        loginPage.enterPassword("123456");
        loginPage.signinbutton();

        ProductBarcodeManagement productBarcodeManagementscreen = new ProductBarcodeManagement(DriverFactory.getDriver());

        productBarcodeManagementscreen.sidemenu();
        try {
            productBarcodeManagementscreen.Searchnewbarcode("richard millie ultra luxury watch", "32324343434");

            String actualmessage = productBarcodeManagementscreen.successmessage();
            String expectedmessage = "Barcodes updated successfully";
            Assert.assertEquals(actualmessage, expectedmessage);
        }catch (AssertionError|Exception e){
            System.out.println("Barcode updated Falied! ");
            e.printStackTrace();
            throw e;
        }
    }
}
