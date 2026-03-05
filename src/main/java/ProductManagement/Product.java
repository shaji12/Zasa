package ProductManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product {
	
	private WebDriver driver;
	
	private By ProductManagement = By.xpath("//span[contains(text(),'Product Management')]");
	private By productsidemenu = By.xpath("//button[text()='Product']");
	private By AddProduct = By.xpath("//button[text()='Add Product']");
	private By ProductName = By.id("productname");
	private By Categorydropdown = By.xpath("(//span[@class='text-[#71717A]'])[1]");
	private By CategoryOption = By.xpath("//li//span[normalize-space()='Uniform']");
	private By Description = By.xpath("(//div[@class='ql-editor ql-blank'])[1]");
	private By selectbranddropdown = By.xpath("//span[contains(text(),'Select Brand')]");
	private By branddropdownOption = By.xpath("//li//span[normalize-space()='NIMS']");
	private By Itemtype_Field = By.xpath("//span[contains(text(),'Select Item Type')]");
	private By ItemtypedropdownOption = By.xpath("//li//span[text()='ACCESSORY']");
	private By Itemsize_Field = By.xpath("//span[contains(text(),'Select Item Size')]");
	private By Itemsize_Dropdown_Option = By.xpath("//div//span[contains(text(),'105')]");
	private By Gender_Field = By.xpath("//div//span[contains(text(),'Select Gender')]");
	private By Gender_Dropdwon_Option = By.xpath("private By Gender_Field");
	private By stockcategory_Field = By.xpath("//span[contains(text(),'Select Stock Category')]");
	private By stockcategory_dropdown_option = By.xpath("//li//span[contains(text(),'Core Uniform')]");
	private By SelectGrade_Field = By.xpath("//span[contains(text(),'Select Grade')]");

	private By Grade_dropdown_Option = By.xpath("//div//span[contains(text(),'Pre-Primary')]");
	private By Purchase_Price = By.id("price");
	private By Selling_Price = By.id("sellingprice");
	private By SelectInstitution = By.xpath("//span[contains(text(),'Select Institution')]");
	private By selectInstitution_dropdown_Option = By
			.xpath("//div//span[contains(text(),'New Indian Model School, Dubai')]");
	
	public Product(WebDriver driver) {
		this.driver = driver;
	}
	
	public void productmanagementdrop() {
		driver.findElement(ProductManagement).click();
	}
	public void clickproductsidemenu() {
		driver.findElement(productsidemenu).click();
	}
	
	public void clickAddProduct() {
		driver.findElement(AddProduct).click();
	}
	
	public void Enterproductname(String productname) {
		driver.findElement(ProductName).sendKeys(productname);
	}
	
	public void selectCategory() {
		driver.findElement(Categorydropdown).click();
		driver.findElement(CategoryOption).click();
	}
}