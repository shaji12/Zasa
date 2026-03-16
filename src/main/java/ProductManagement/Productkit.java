package ProductManagement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Productkit {

    //contract
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    public Productkit(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);

    }

    // --- Add Productkit Locators ---
    @FindBy(xpath = "//span[text()='Product Management']")
    private WebElement productManagement;

    @FindBy(xpath = "//button[text()='Product Kit']")
    private WebElement productkitSideMenu;

    @FindBy(xpath = "//button[text()='Add Kit']")
    private WebElement addkitbutton;

    @FindBy(id ="kitname")
    private WebElement enterkitName;

    @FindBy(xpath = "//div//span[text()='Select an option...']")
    private WebElement categoryDropdown;

    @FindBy(xpath = "//li//span[normalize-space()='Uniform']")
    private WebElement categoryOption;

    @FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
    private WebElement description;

    @FindBy(xpath = "//div//span[text()='Add Product Size Chart']")
    private WebElement AddProductSizeChart;

    @FindBy(xpath = "//div//span[text()='Select an option...']")
    private WebElement kitTypeField;

    @FindBy(xpath = "//li[span[text()='Core Uniform']]")
    private WebElement kitTypeOption;

    @FindBy(xpath = "//span[contains(text(),'Select Gender')]")
    private WebElement genderField;

    @FindBy(xpath = "//li//span[text()='Male']")
    private WebElement genderOption;

    @FindBy(xpath = "//span[contains(text(),'Select Institution')]")
    private WebElement institutionField;

    @FindBy(xpath = "//li//span[contains(text(),'New Indian Model School, Dubai')]")
    private WebElement InstitutionOption;

    @FindBy(xpath = "//span[contains(text(),'Select Grade(s)')]")
    private WebElement gradeField;

    @FindBy(xpath = "//div//span[contains(text(),'Pre-Primary')]")
    private WebElement gradeOption;

    @FindBy(xpath = "//input[@placeholder='Search Item Code / Item Name / Barcode']")
    private WebElement itemField;

    @FindBy(xpath = "//div//div[text()='Hive uniforms']")
    private WebElement itemOption;

    @FindBy(xpath = "//div[text()='Item Added!']")
    private WebElement itemAddedSuccess;

    @FindBy(xpath = "//div//span[text()='Select Kit Status Type']")
    private WebElement kitStatusTypeField;

    @FindBy(xpath = "//div//span[text()='Online Kit']")
    private WebElement kitStatusTypeOption;

    @FindBy(xpath = "//button[text()='Save Product Kit']")
    private WebElement saveProductKit;


    // ------------------- Methods -------------------
    // Scroll and click helper (works on mac & Windows)

    public void clickElements(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try{
            element.click();
        } catch (Exception e){
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void clearandsendkey(WebElement element, String text){
        try {
            element.clear();
        } catch (Exception e){
            js.executeScript("arguments[0].value='';", element);
            js.executeScript("arguments[0].innerHTML='';", element);
        }
        element.sendKeys(text);
    }

    public void sidemenu(){
        clickElements(productManagement);
        clickElements(productkitSideMenu);
    }
    public void addproduct(){
        clickElements(addkitbutton);
    }

    public void enterkitName(String name){
        clearandsendkey(enterkitName, name);
    }

    public void selectcategory(){
        categoryDropdown.click();
        categoryOption.click();
    }

    public void description(String descr){
        clearandsendkey(description, descr);
    }

    public void SizeChartImage(){
        AddProductSizeChart.sendKeys();
    }

    public void kitType(){
        clickElements(kitTypeField);
        clickElements(kitTypeOption);
    }

    public void selectgender(){
        clickElements(genderField);
        clickElements(genderOption);
    }

    public void institution(){
        clickElements(institutionField);
        clickElements(InstitutionOption);
    }

    public void grade(){
        clickElements(gradeField);
        clickElements(gradeOption);
    }
    public void selectitem(){
        clickElements(itemField);
        clickElements(itemOption);
    }
    public String itemAddedSuccess(){
        return itemAddedSuccess.getText();
    }

    public void kitStatusType(){
        clickElements(kitStatusTypeField);
        clickElements(kitStatusTypeOption);
    }

    public void saveProductKit(){
        saveProductKit.click();
    }

}
