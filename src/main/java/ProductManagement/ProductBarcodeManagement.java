package ProductManagement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductBarcodeManagement {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public ProductBarcodeManagement(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js=(JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Product Management']")
    private WebElement productManagement;

    @FindBy(xpath = "//button[contains(text(),'Product Barcode Management')]")
    private WebElement ProductBarcodeManagement;

    @FindBy(xpath = "//input[@placeholder='Search by Product Name, Category, or Barcode']")
    private WebElement Searchplaceholder;

    @FindBy(xpath = "//input[@placeholder='Enter New Barcode']")
    private WebElement EnternewBarcode;

    @FindBy(xpath = "//button[contains(text(),'SAVE')]")
    private WebElement Savebutton;

    @FindBy(xpath = "//div[contains(text(),'Barcodes updated successfully')]")
    private WebElement sucessmessage;

    // ------------------- Methods -------------------
    // Scroll and click helper (works on mac & Windows)

    private void clickElements(WebElement element, String elementName){
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
            System.out.println("clicked on:"+elementName);
        }catch (Exception e){
            js.executeScript("arguments[0].click();", element);
            System.out.println("Clicked using JS on: " + elementName);
        }
    }

    public void clearandsendkey(WebElement element, String text){
        try{
            element.clear();
        } catch (Exception e){
            js.executeScript("arguments[0].value='';", element);
            js.executeScript("arguments[0].innerHTML='';", element);
        }
        element.sendKeys(text);
    }

    public void sidemenu(){
        clickElements(productManagement, "productManagement");
        clickElements(ProductBarcodeManagement, "ProductBarcodeManagement");
    }

    public void Searchnewbarcode(String searchname, String barcodeno){
        clearandsendkey(Searchplaceholder, searchname);
        clearandsendkey(EnternewBarcode, barcodeno);
        clickElements(Savebutton, "Savebutton");
    }

    public String successmessage(){
        return sucessmessage.getText();
    }
}
