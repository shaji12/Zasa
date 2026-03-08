package ProductManagement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {

    private WebDriver driver;
    private WebDriverWait wait;

    public Product(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

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
    
    @FindBy(xpath = "(//li[@class='flex items-center justify-between px-4 py-2 cursor-pointer text-sm transition-all hover:bg-[#F0E7F9] text-gray-900'])[1]")
    private WebElement brandOption;

    @FindBy(xpath = "//span[contains(text(),'Select Item Type')]")
    private WebElement itemTypeField;

    By itemTypeOption = By.xpath("//li//span[text()='ACCESSORY']");

    @FindBy(xpath = "//span[contains(text(),'Select Item Size')]")
    private WebElement itemSizeField;

    @FindBy(xpath = "//div//span[contains(text(),'105')]")
    private WebElement itemSizeOption;

    @FindBy(xpath = "//div//span[contains(text(),'Select Gender')]")
    private WebElement genderField;

    @FindBy(xpath = "//li//span[contains(text(),'All')]")
    private WebElement genderOption;

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
    
    // Delete Path
    
    @FindBy(xpath = "//table[@class='w-full divide-y divide-gray-200']")
    List<WebElement> productNames;
    
    @FindBy(xpath ="(//button[@aria-haspopup='menu']")
    List<WebElement> threeDotMenus;
    
    @FindBy(xpath = "(//div[@role=\"menuitem\"])[3]")
    private WebElement deleteOption;
    
    //@FindBy(id = "radix-:r4:")
    //private WebElement deleteComfirmPopup;
    
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement confirmDelete;
    
    //@FindBy (xpath ="(//li//div[text()='Product deleted successfully.'])[1]")
    //private WebElement successMessage;
    
    

    // Add Product

    public void productmanagementdrop() {
        wait.until(ExpectedConditions.elementToBeClickable(productManagement)).click();
    }

    public void clickproductsidemenu() {
        wait.until(ExpectedConditions.elementToBeClickable(productSideMenu)).click();
    }

    public void clickAddProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(addProduct)).click();
    }

    public void enterProductName(String name) {
        wait.until(ExpectedConditions.visibilityOf(productName)).sendKeys(name);
    }

    public void selectCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(categoryDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(categoryOption)).click();
    }

    public void enterDescription(String desc) {
        wait.until(ExpectedConditions.visibilityOf(description)).sendKeys(desc);
    }

    public void selectBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(brandOption)).click();
    }

    public void selectItemType() {
        wait.until(ExpectedConditions.elementToBeClickable(itemTypeField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(itemTypeOption)).click();
    }

    public void selectItemSize() {
        wait.until(ExpectedConditions.elementToBeClickable(itemSizeField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(itemSizeOption)).click();
    }

    public void selectGender() {
        wait.until(ExpectedConditions.elementToBeClickable(genderField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(genderOption)).click();
    }

    public void enterPurchasePrice(String price) {
        wait.until(ExpectedConditions.visibilityOf(purchasePrice)).sendKeys(price);
    }

    public void enterSellingPrice(String price) {
        wait.until(ExpectedConditions.visibilityOf(sellingPrice)).sendKeys(price);
    }

    public void selectInstitution() {
        wait.until(ExpectedConditions.elementToBeClickable(selectInstitution)).click();
        wait.until(ExpectedConditions.elementToBeClickable(institutionOption)).click();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitbutton)).click();
    }
    
    //Delete  Product
    
    public void deleteProduct(String productName) {
    	for(int i = 0; i < productNames.size(); i++) {
    		if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
    			threeDotMenus.get(i).click();
    			deleteOption.click();
    			confirmDelete.click();
    			break;
    		}
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
  //  public void productnamethreedots(String productname) {
        //String menuXpath = "//span[normalize-space()='" + productname + "']/ancestor::div//button[@aria-haspopup='menu']";
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuXpath)));
      //  menu.click();
    //}

    
}