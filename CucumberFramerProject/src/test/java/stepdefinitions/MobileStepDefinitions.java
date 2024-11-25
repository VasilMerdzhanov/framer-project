package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MobileStepDefinitions {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;
    
    @Given("the Framer site is loaded on mobile")
    public void the_Framer_site_is_loaded_on_mobile() {
        // Resize browser to simulate a mobile view (e.g., 375x667 for iPhone X)
        driver.manage().window().setSize(new Dimension(375, 667));

        // Load the Framer site
        driver.get("https://mind-wend-913065.framer.app/");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @Then("I see the 'get the app' and 'watch video' buttons are displayed one above the other on mobile")
    public void i_see_the_get_the_app_and_watch_video_buttons_are_displayed_one_above_the_other_on_mobile() {
        // Locate the buttons
        WebElement getTheAppButton = driver.findElement(By.xpath("//span[text()='Get the App']"));
        WebElement watchVideoButton = driver.findElement(By.xpath("//span[text()='Watch video']"));

        // Get the vertical positions of the buttons
        int getTheAppY = getTheAppButton.getRect().getY();
        int watchVideoY = watchVideoButton.getRect().getY();

        // Validate that "Get the app" is above "Watch video"
        Assert.assertTrue(getTheAppY < watchVideoY, "'Get the app' button is not above 'Watch video' button on mobile.");
    }
}
