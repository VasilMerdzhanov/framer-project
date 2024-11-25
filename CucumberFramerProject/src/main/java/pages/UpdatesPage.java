package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseSetup;

public class UpdatesPage extends BaseSetup{
    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath = "//span[text()='Stay up-to-date with new courses, tutorials and livestreams.']")
	private WebElement updatesPage;
    
    public UpdatesPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    public void isUpdatesPageDisplayed() {
    	updatesPage.isDisplayed();
    }
}
