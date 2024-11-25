package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PricingPage{
    WebDriver driver;
    private WebDriverWait wait;

	@FindBy(xpath = "//span[text()='Launch a site for free. Choose a site plan to unlock more features.']")
	private WebElement pricingPage;
	
    @FindBy(xpath = "//*[contains(text(), '$')]")
    private List<WebElement> currencySymbols;

    @FindBy(xpath = "//*[contains(text(), '?')]")
    private List<WebElement> faqQuestions;

    public PricingPage(WebDriver driver) {
    	
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void scrollToCurrencySymbols() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scroll(0,300)");
    }
    
    public boolean areCurrencySymbolsDisplayed() {
    	wait.until(ExpectedConditions.visibilityOfAllElements(currencySymbols));
        // Validate all elements contain the "$" symbol and are displayed
        for (WebElement symbol : currencySymbols) {
            if (!symbol.isDisplayed() || !symbol.getText().contains("$")) {
                return false; // Return false if any symbol is not displayed or does not contain "$"
            }
        }
        return true; // Return true if all symbols are displayed and contain "$"
    }

    public int getFAQCount() {
        return faqQuestions.size();
    }
    
    public void isPricingPageDisplayed() {
    	pricingPage.isDisplayed();
    }
}
