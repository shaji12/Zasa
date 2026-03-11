package ProductManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productkit {

    private WebDriver driver;

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

    //

    @FindBy(xpath = "//div[text()='Item Added!']")
    private WebElement itemAddedSuccess;

    @FindBy(xpath = "//div//span[text()='Select Kit Status Type']")
    private WebElement kitStatusTypeField;

    @FindBy(xpath = "//div//span[text()='Online Kit']")
    private WebElement kitStatusTypeOption;

    @FindBy(xpath = "//button[text()='Save Product Kit']")
    private WebElement saveProductKit;





}
