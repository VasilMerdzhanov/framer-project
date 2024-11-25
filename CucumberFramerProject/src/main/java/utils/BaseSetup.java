package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSetup {
    protected static WebDriver driver;
    private WebDriverWait wait;
    

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://mind-wend-913065.framer.app/");
        }
        return driver;
    }
    
    public BaseSetup(WebDriver driver) {
    	BaseSetup.driver = driver;
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	PageFactory.initElements(driver, this);
    }
    
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();
    }
   
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        } 
    }
}
