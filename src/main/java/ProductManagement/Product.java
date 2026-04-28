package ProductManagement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public Product(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased for macOS
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // --- Add Product Locators ---
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
    
    @FindBy(xpath = "//div//span[text()='NIMS']")
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

    @FindBy(xpath = "//span[text()='All']")
    private WebElement genderOption;
    
    @FindBy(xpath = "//div[span[text()='Select Stock Category']]")
    private WebElement stockCategoryField;
    
    @FindBy(xpath = "//li[span[text()='Core Uniform']]")
    private WebElement stockCategoryOption;
    
    @FindBy(xpath = "(//button[@aria-haspopup='dialog'])[2]")
    private WebElement gradeField;
    
    @FindBy(xpath ="(//div[contains(@class,'cursor-pointer px-2')])[3]")
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
    
    @FindBy(xpath = "//div[text()='Product added successfully.']")
    private WebElement successMessage;

    // --- Edit Product Locators ---
    @FindBy(xpath = "//input[@placeholder=\"Search by Product Name or Category\"]")
    private WebElement Searchplaceholder;
    
    @FindBy(xpath = "(//button[@class='focus:outline-none'])[1]")
    private WebElement threeDotMenuss;
    
    @FindBy(xpath = "//div[normalize-space()='Edit']")
    private WebElement EditOption;
    
    @FindBy(xpath = "//input[@name=\"productname\"]")
    private WebElement EditproductName;
    
    @FindBy(xpath ="//div[text() ='Product updated successfully.']")
    private WebElement updatedsuccess;

    // --- Delete Product Locators ---
    @FindBy(xpath = "//table[@class='w-full divide-y divide-gray-200']")
    List<WebElement> productNames;
    
    @FindBy(xpath ="(//button[@class='focus:outline-none'])[1]")
    private WebElement threeDotMenus;
    
    @FindBy(xpath = "(//div[@role=\"menuitem\"])[3]")
    private WebElement deleteOption;
    
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement confirmDelete;
    
    @FindBy(xpath ="//div[text()='Product deleted successfully.']")
    private WebElement deletedsuccess;

    // ------------------- Methods -------------------

    // Scroll and click helper (works on mac & Windows)
    private void clickElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", element);
        }
    }

    // Clear input safely (including JS editors)
    private void clearAndSendKeys(WebElement element, String text) {
        try {
            element.clear();
        } catch (Exception e) {
            js.executeScript("arguments[0].value='';", element);
            js.executeScript("arguments[0].innerHTML='';", element);
            //js.executeScript("arguments[0].value=''; arguments[0].dispatchEvent(new Event('input'));", element);
        }
        element.sendKeys(text);
    }

    // ------------------- Add Product -------------------
    public void productmanagementdrop() {
        clickElement(productManagement);
    }

    public void clickproductsidemenu() {
        clickElement(productSideMenu);
    }

    public void clickAddProduct() {
        clickElement(addProduct);
    }

    public void enterProductName(String name) {
        clearAndSendKeys(productName, name);
    }

    public void selectCategory() {
        clickElement(categoryDropdown);
        clickElement(categoryOption);
    }

    public void enterDescription(String desc) {
        clearAndSendKeys(description, desc);
    }

    public void selectBrand() {
        clickElement(brandDropdown);
        clickElement(brandOption);
    }

    public void selectItemType() {
        clickElement(itemTypeField);
        WebElement typeOption = driver.findElement(itemTypeOption);
        clickElement(typeOption);
    }

    public void selectItemSize() {
        clickElement(itemSizeField);
        clickElement(itemSizeOption);
    }

    public void selectGender() {
        clickElement(genderField);
        clickElement(genderOption);
    }
    
    public void selectStockCategory() {
        clickElement(stockCategoryField);
        clickElement(stockCategoryOption);
    }
    
    public void selectGrade() {
        clickElement(gradeField);
        clickElement(gradeOption);
    }
    
    public void enterPurchasePrice(String price) {
        clearAndSendKeys(purchasePrice, price);
    }

    public void enterSellingPrice(String price) {
        clearAndSendKeys(sellingPrice, price);
    }

    public void selectInstitution() {
        clickElement(selectInstitution);
        clickElement(institutionOption);
    }

    public void clickSubmit() {
        clickElement(submitbutton);
    }
    
    public String getSuccessMessage() {
        return successMessage.getText();
    }

    // ------------------- Edit Product -------------------
    public void searchProduct(String productNameText) {
        clearAndSendKeys(Searchplaceholder, productNameText);
    }
 
    public void openEditMenu() {
        clickElement(threeDotMenuss);
        clickElement(EditOption);
    }
 
    public void changeProductName(String name) {
    	clickElement(EditproductName);
    	clearAndSendKeys(EditproductName, name);
    }
 
    public void clickSaveButton() {
        clickElement(submitbutton);
    }
    
    public String getupdatedsucess() {
    	return updatedsuccess.getText();
    }

    // ------------------- Delete Product -------------------
    
    
    public void searchProducts(String searchproducts) {
    	clearAndSendKeys(Searchplaceholder,searchproducts );
    }
    
    public void deleteproduct() {
    	clickElement(threeDotMenus);
    	clickElement(deleteOption);
    	clickElement(confirmDelete);
    }
    
    public String deletedsuccess() {
    	return deletedsuccess.getText();
    }
    
}