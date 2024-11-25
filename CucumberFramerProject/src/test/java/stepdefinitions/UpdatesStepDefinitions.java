package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.ComponentsPage;
import pages.UpdatesPage;
import utils.BaseSetup;

public class UpdatesStepDefinitions {
	WebDriver drive;
    ComponentsPage homePage = new ComponentsPage(BaseSetup.getDriver());
    UpdatesPage updatesPage = new UpdatesPage(BaseSetup.getDriver());
    
    @And("I see the {string} button")
    public void i_see_the_button(String updatesButton) {
    	Assert.assertTrue(homePage.areVisitButtonsDisplayed(), "Updates button is not displayed.");
    }

    @When("I click on the 'Updates' button")
    public void clickPricingButton() {
        homePage.clickUpdates();
    }
    
    @Then("I see the Updates page is displayed")
    public void i_see_the_pricing_page() {
    	updatesPage.isUpdatesPageDisplayed();
    }
}