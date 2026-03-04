package ProductManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class product {
	
	private WebDriver driver;
	
	private By ProductManagement = By.xpath("//span[contains(text(),'Product Management')]");
	private By productsidemenu = By.xpath("//button[text()='Product']");
	private By AddProduct = By.xpath("//button[text()='Add Product']");
	private By ProductName = By.id("productname");
	private By Category = By.xpath("(//span[@class='text-[#71717A]'])[1]");
			
	
	public void productmanagementdrop() {
		driver.findElement(ProductManagement).click();
	}

}
