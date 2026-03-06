package ProductManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Product {

    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Product Management']")
    private WebElement productManagement;

    @FindBy(xpath = "//button[text()='Product']")
    private WebElement productSideMenu;

    @FindBy(xpath = "//button[text()='Add Product']")
    private WebElement addProduct;

    @FindBy(id = "productname")
    private WebElement productName;

    @FindBy(xpath = "(//span[@class='text-[#71717A]'])[1]")
    private WebElement categoryDropdown;

    @FindBy(xpath = "//li//span[normalize-space()='Uniform']")
    private WebElement categoryOption;

    @FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
    private WebElement description;

    @FindBy(xpath = "//span[contains(text(),'Select Brand')]")
    private WebElement brandDropdown;

    @FindBy(xpath = "//li//span[normalize-space()='NIMS']")
    private WebElement brandOption;

    @FindBy(xpath = "//span[contains(text(),'Select Item Type')]")
    private WebElement itemTypeField;

    @FindBy(xpath = "//li//span[text()='ACCESSORY']")
    private WebElement itemTypeOption;

    @FindBy(xpath = "//span[contains(text(),'Select Item Size')]")
    private WebElement itemSizeField;

    @FindBy(xpath = "//div//span[contains(text(),'105')]")
    private WebElement itemSizeOption;

    @FindBy(xpath = "//div//span[contains(text(),'Select Gender')]")
    private WebElement genderField;

    @FindBy(xpath = "//li//span[contains(text(),'Male')]")
    private WebElement genderOption;

    @FindBy(xpath = "//span[contains(text(),'Select Stock Category')]")
    private WebElement stockCategoryField;

    @FindBy(xpath = "//li//span[contains(text(),'Core Uniform')]")
    private WebElement stockCategoryOption;

    @FindBy(xpath = "//span[contains(text(),'Select Grade')]")
    private WebElement gradeField;

    @FindBy(xpath = "//div//span[contains(text(),'Pre-Primary')]")
    private WebElement gradeOption;

    @FindBy(id = "price")
    private WebElement purchasePrice;

    @FindBy(id = "sellingprice")
    private WebElement sellingPrice;

    @FindBy(xpath = "//span[contains(text(),'Select Institution')]")
    private WebElement selectInstitution;

    @FindBy(xpath = "//div//span[contains(text(),'New Indian Model School, Dubai')]")
    private WebElement institutionOption;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitbutton;

    public Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       
    }

    public void productmanagementdrop() {
        Object wait;
        wait.until(ExpectedConditions.elementToBeClickable(productManagement).click();
    }
    public void clickproductsidemenu() {
        productSideMenu.click();
    }

    public void clickAddProduct() {
        addProduct.click();
    }

    public void Enterproductname(String productname) {
        productName.sendKeys(productname);
    }

    public void selectCategory() {
        categoryDropdown.click();
        categoryOption.click();
    }

    public void enterDescription(String descri) {
        description.sendKeys(descri);
    }

    public void selectbrand() {
        brandDropdown.click();
        brandOption.click();
    }

    public void selectItemtype() {
        itemTypeField.click();
        itemTypeOption.click();
    }
    
    public void selectitemSize() {
    	itemSizeField.click();
    	itemSizeOption.click();
    }
    
    public void selectgenderField() {
    	genderField.click();
    	genderOption.click();
    }
    
    public void enterpurchasePrice(String Price) {
    	purchasePrice.sendKeys(Price);
    	
    }
    
    public void entersellingPrice(String sellingprice) {
    	sellingPrice.sendKeys(sellingprice);
    }
    
    public void enterInstitution() {
    	selectInstitution.click();
    	institutionOption.click();
    }
    
    public void submit() {
    	submitbutton.click();
    }
}