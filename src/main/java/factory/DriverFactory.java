package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
		    options.addArguments("--incognito");
            driver.set(new ChromeDriver(options));
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }
    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() !=null){
        //    driver.get().quit();
          //  driver.remove();
        }
    }
}
