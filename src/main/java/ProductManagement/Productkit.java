package ProductManagement;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @FindBy(id = "product-size-chart")
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

    @FindBy(xpath = "//div[text() = 'yellow shirt']")
    private WebElement itemOption;

    @FindBy(xpath = "(//div[text()='Item Added!'])[1]")
    private WebElement itemAddedSuccess;

    @FindBy(xpath = "//div//span[text()='Select Kit Status Type']")
    private WebElement kitStatusTypeField;

    @FindBy(xpath = "//div//span[text()='Online Kit']")
    private WebElement kitStatusTypeOption;

    @FindBy(xpath = "//button[text()='Save Product Kit']")
    private WebElement saveProductKit;

    @FindBy(xpath = "(//div[text()='Product kit added successfully.'])[2]")
    private WebElement productkitsuccess;

    @FindBy(xpath = "//input[@placeholder=\"Search by Kit Name and Category\"]")
    private WebElement SearchBar;

    @FindBy(xpath = "(//button[@class='focus:outline-none'])[1]")
    private WebElement threeDotMenuss;

    @FindBy(xpath = "//div[@role='menuitem' and normalize-space()='Copy']")
    private WebElement Copybutton;

    @FindBy(xpath = "//span[normalize-space()='Select Institution']")
    private WebElement Institution;

    @FindBy(xpath = "//div//span[normalize-space()='New Indian Model School,Sharjah']")
    private WebElement SelectInstitution;

    @FindBy (xpath = "//button[text()='Copy Kit']")
    private WebElement Copykitbutton;

    @FindBy(xpath = "//button[text()='Close']")
    private WebElement CopyKitResultCloseButton;



    // ------------------- Methods -------------------
    // Scroll and click helper (works on mac & Windows)

    public void clickElements(WebElement element, String elementName){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try{
            element.click();
            System.out.println("clicked on:" + elementName);
        } catch (Exception e){
            js.executeScript("arguments[0].click();", element);
            System.out.println("Clicked using JS on: " + elementName);
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
        clickElements(productManagement, "Product Management");
        clickElements(productkitSideMenu, "Product Kit Menu");
    }
    public void addproduct(){
        clickElements(addkitbutton, "Add Kit Button ");
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

    public void SizeChartImage(String filePath){
        AddProductSizeChart.sendKeys(filePath);
    }

    public void kitType(){
        clickElements(kitTypeField, "Kit Type Field");
        clickElements(kitTypeOption, "Kit Type Option");
    }

    public void selectgender(){
        clickElements(genderField, "gender Field");
        clickElements(genderOption, "Gender Option");
    }

    public void institution(){
        clickElements(institutionField, "Institution Field");
        clickElements(InstitutionOption, "Institution Option");
    }

    public void grade(){
        clickElements(gradeField, "grade Field");
        clickElements(gradeOption, "gradeOption");
    }
    public void selectitem(String name){
        clearandsendkey(itemField, name);
        clickElements(itemOption, "Item Option");
    }
    public String itemAddedSuccess(){
        WebElement message = wait.until(
          ExpectedConditions.visibilityOf(itemAddedSuccess)
        );
        return message.getText();
    }

    public void kitStatusType(){
        clickElements(kitStatusTypeField, "kitStatusType Field");
        clickElements(kitStatusTypeOption, "kitStatusType Option");

    }

    public void saveProductKit(){
        saveProductKit.click();
    }
    public String productkitsuccessMessage(){
        return productkitsuccess.getText();
    }

    //Copy

    public void searchproduct(String name){
        clearandsendkey(SearchBar, name);
    }
    // ===================== ACTION METHODS =====================

    public void copyKitToInstitution(){
        clickThreeDotMenu();
        clickCopyOption();
        openInstitutionDropdown();
        selectInstitutionOption();
        clickCopyKitButton();
        closeCopyPopup();
    }
    // ===================== STEP METHODS =====================

    private void clickThreeDotMenu(){
        clickElements(threeDotMenuss, "Three Dot Menu");
    }

    private void clickCopyOption(){
        clickElements(Copybutton, "Copy Option");
    }

    private void openInstitutionDropdown(){
        clickElements(Institution, "Institution Dropdown");
    }

    private void selectInstitutionOption(){
        clickElements(SelectInstitution, "Select Institution");
    }

    private void clickCopyKitButton(){
        clickElements(Copykitbutton, "Copy Kit Button");
    }

    private void closeCopyPopup(){
        clickElements(CopyKitResultCloseButton, "Close Button");
    }
}
