package ProductManagementTest;

import Loginpages.LoginPage;
import ProductManagement.Productkit;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Productkitscreen extends BaseTest {

    @Test
    public void productkit(){

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("ajay@store.com");
        loginPage.enterPassword("123456");
        loginPage.signinbutton();

        Productkit productkitscreen = new Productkit(driver);

        productkitscreen.sidemenu();
        productkitscreen.addproduct();
        productkitscreen.enterkitName("Today Kit");
        productkitscreen.selectcategory();
        productkitscreen.description("desc");
      //  productkitscreen.SizeChartImage();
        productkitscreen.kitType();
        productkitscreen.selectgender();
        productkitscreen.institution();
        productkitscreen.grade();
        productkitscreen.selectitem();

        String actual = productkitscreen.itemAddedSuccess();
        String Expected = "Item Added!";
        Assert.assertEquals(actual,Expected);

        productkitscreen.kitStatusType();
        productkitscreen.saveProductKit();
    }
}
