package ProductManagement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class Productsettings {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public Productsettings(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased for macOS
        this.js =(JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Product Management']")
    private WebElement productManagement;

    @FindBy(xpath = "//button[text()='Product Settings']")
    private WebElement productSettings;

    @FindBy(xpath = "//button[normalize-space()='COLOR']")
    private WebElement Color;

    @FindBy(xpath = "//button[normalize-space()='Add Color']")
    private WebElement AddColor;

    @FindBy(id = "colorname")
    private WebElement enterthecolor;

    @FindBy(xpath = "//div//input[@name='colorcode']")
    private WebElement entercolorcode;

    @FindBy(xpath = "//li//span[contains(text(),'Uniform')]")
    private WebElement category;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitbutton;

    @FindBy(xpath = "//div[contains(text(),'Color added successfully.')]")
    private WebElement sucessmessage;

    @FindBy(xpath = "//input[@placeholder='Search by Color Name']")
    private WebElement searchbar;

    @FindBy(xpath = "//button[@aria-label='Edit']")
    private WebElement Editbutton;

    @FindBy(xpath = "//div[contains(text(), 'Color updated successfully.')]")
    private WebElement Updatesuccess;

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private WebElement Deletebutton;

    @FindBy(xpath="//button[normalize-space()='OK']")
    private WebElement deletepopok;

    @FindBy(xpath = "//div[text()='Colour deleted successfully.']")
    private WebElement Deletesuccess;




    // ------------------- Methods -------------------
    // Scroll and click helper (works on mac & Windows)

    public void clickElements(WebElement element, String elementName) {
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
        try{
            element.clear();
        } catch (Exception e){
            js.executeScript("arguments[0].value='';", element);
            js.executeScript("arguments[0].innerHTML='';", element);
        }
        element.sendKeys(text);
    }


    public void sidemenu(){
        clickElements(productManagement, "Product Management");
        clickElements(productSettings, "product setting");
        clickElements(Color, "color");

    }

    //Add color

    public void AddColorbutton(){
        clickElements(AddColor,"addcolor");
    }

    public void AddColor(String Colorname, String colorcode){
        clearandsendkey(enterthecolor, Colorname);
        clearandsendkey(entercolorcode, colorcode);
        clickElements(submitbutton, "submit");
    }
    public String Addcolorsucessmessage(){
        return sucessmessage.getText();
    }

    //SearchwithEdit

    public void Search(String colornamesearch){
        clearandsendkey(searchbar, colornamesearch);
    }

    public void Edit(String Colornamechange){
        clickElements(Editbutton, "editbutton");
        clearandsendkey(enterthecolor, Colornamechange);
        clickElements(submitbutton, "Editsubmit");
    }

    public String Updatesucessmessage(){
        return Updatesuccess.getText();
    }

    //Delete
    public void Searchclear(String colornamesearch){
        clearandsendkey(searchbar, colornamesearch);
    }

    public void deletecolor(){
        clickElements(Deletebutton, "Deletebutton");
        clickElements(deletepopok, "deletepopok");
    }

    public String Deletesuccessmessage(){
        return Deletesuccess.getText();
    }
}

