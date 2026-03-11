package ProductManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productkit {

    //contract
    private WebDriver driver;
    public Productkit(WebDriver driver) {
        this.driver=driver;
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

    public void sidemenu(){
        productManagement.click();
        productkitSideMenu.click();
    }
    public void addproduct(){
        addkitbutton.click();
    }

    public void enterkitName(String name){
        enterkitName.sendKeys();
    }

    public void selectcategory(){
        categoryDropdown.click();
        categoryOption.click();
    }

    public void description(String descr){
        description.sendKeys();
    }

    public void SizeChartImage(){
        AddProductSizeChart.sendKeys();
    }

    public void kitType(){
        kitTypeField.click();
        kitTypeOption.click();
    }

    public void selectgender(){
        genderField.click();
        genderOption.click();
    }

    public void institution(){
        institutionField.click();
        InstitutionOption.click();
    }

    public void grade(){
        gradeField.click();
        gradeOption.click();
    }
    public void selectitem(){
        itemField.click();
        itemOption.click();
    }
    public String itemAddedSuccess(){
        return itemAddedSuccess.getText();
    }

    public void kitStatusType(){
        kitStatusTypeField.click();
        kitStatusTypeOption.click();
    }

    public void saveProductKit(){
        saveProductKit.click();
    }

}
