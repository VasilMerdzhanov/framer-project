package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseSetup;

import java.time.Duration;
import java.util.List;

public class ComponentsPage extends BaseSetup {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//span[text()='Create a 3D background animation']")
	WebElement componentPage;

	@FindBy(xpath = "//span[text()='Pricing']") 
	WebElement pricingButton;

	@FindBy(xpath = "//span[text()='Components']")
	WebElement componentsButton;

	@FindBy(xpath = "//span[text()='Updates']")
	WebElement updatesButton;

	@FindBy(xpath = "//span[text()='Sign Up']")
	WebElement signUpButton;

	@FindBy(xpath = "//input[@value='Sign Up']")
	WebElement bottomSignUpButton;

	@FindBy(xpath = "//span[text()='Get the App']")
	WebElement getAppButton;

	@FindBy(xpath = "//span[text()='Visit']")
	private List<WebElement> visitButtons;

	@FindBy(xpath = "//span[text()='Download']")
	private WebElement downloadButton;
	
	@FindBy(xpath = "//span[text()='Watch video']")
	private WebElement watchVideoButton;
	
	@FindBy(xpath = "//span[text()='Watch video']")
	private WebElement getTheAppButton;

	public ComponentsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void clickPricing() {
		pricingButton.click();
	}

	public void clickComponents() {
		clickElement(componentsButton);
	}

	public void clickUpdates() {
		clickElement(updatesButton);
	}

	public void clickSignUp() {
		clickElement(signUpButton);
	}

	public void clickGetApp() {
		clickElement(getAppButton);
	}

	public boolean areVisitButtonsDisplayed() {

		// Validate all cards contain the "Visit" buttons and are displayed
		for (WebElement visit : visitButtons) {
			if (!visit.isDisplayed() || !visit.getText().contains("Visit")) {
				return false; // Return false if any symbol is not displayed or does not contain "$"
			}
		}
		return true;
	}

	public boolean isUpdatesBtnDisplayed() {
		
		if (!updatesButton.isDisplayed()) {
			return false;
		}
		return true;
	}
	
	public boolean isGetTheAppDisplayed() {
		
		if (!getAppButton.isDisplayed()) {
			return false;
		}
		return true;
	}

	public String getSignUpButtonColor() {
		// wait.until(ExpectedConditions.visibilityOf(signUpButton));
		return bottomSignUpButton.getCssValue("background-color");
	}

	public boolean isUpdatesButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(updatesButton));
		return updatesButton.isDisplayed();
	}

	public boolean isComponentsPageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(componentPage));
		return componentPage.isDisplayed();
	}

	public boolean isDownloadButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(downloadButton));
		return downloadButton.isDisplayed();
	}

	public void scrollToManyTypesSection() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,1850)");
	}

	public void scrollToSignUpButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,3000)");
	}

}
