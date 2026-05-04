package ProductManagementTest;

import Loginpages.LoginPage;
import ProductManagement.Productsettings;
import base.BaseTest;
import factory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Productsettingscreen extends BaseTest {

    @Test
    public void Productsetting(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterUsername("ajay@store.com");
        loginPage.enterPassword("123456");
        loginPage.signinbutton();

        Productsettings Productsettingsreen = new Productsettings(DriverFactory.getDriver());
        Productsettingsreen.sidemenu();

        //AddColor
        try {
            Productsettingsreen.AddColorbutton();
            Productsettingsreen.AddColor("Oranage", "ORGE");

            String actualmessage = Productsettingsreen.Addcolorsucessmessage();
            String expectedmessage = "Color added successfully.";
            Assert.assertEquals(actualmessage,expectedmessage);

        }catch (AssertionError|Exception e){
            System.out.println("Add Color Falied!");
            e.printStackTrace();
            throw e;
        }

        //EditColor
        try {
            Productsettingsreen.Search("Oranage");
            Productsettingsreen.Edit("Oranges");
            String actualmessage = Productsettingsreen.Updatesucessmessage();
            String expectedmessage = "Color updated successfully.";
            Assert.assertEquals(actualmessage,expectedmessage);
        }catch (AssertionError|Exception e){
            System.out.println("Updated Color Failed !");
            e.printStackTrace();
            throw e;

        }

        //DeleteColor
        try {
            Productsettingsreen.Searchclear("Oranges");
            Productsettingsreen.deletecolor();
            String actualmessage = Productsettingsreen.Deletesuccessmessage();
            String expectedmessage = "Colour deleted successfully.";
            Assert.assertEquals(actualmessage, expectedmessage);
        } catch (AssertionError|Exception e){
            System.out.println("Delete Color Failed!");
            e.printStackTrace();
            throw e;
        }
    }
}
