package ProductManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class product {
	
	private WebDriver driver;
	
	private By ProductManagement = By.xpath("//span[contains(text(),'Product Management')]");
	//
	
	public void productmanagementdrop() {
		driver.findElement(ProductManagement).click();
	}

}
