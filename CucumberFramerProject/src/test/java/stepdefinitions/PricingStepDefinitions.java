package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.ComponentsPage;
import pages.PricingPage;
import utils.BaseSetup;

public class PricingStepDefinitions {
	WebDriver drive;
    ComponentsPage homePage = new ComponentsPage(BaseSetup.getDriver());
    PricingPage pricingPage = new PricingPage(BaseSetup.getDriver());

    @When("I click on 'Pricing' button")
    public void clickPricingButton() {
        homePage.clickPricing();
    }
    
    @When("I see the Pricing page")
    public void i_see_the_pricing_page() {
    	pricingPage.isPricingPageDisplayed();
    	pricingPage.scrollToCurrencySymbols();
    }

    @Then("I see the products' currency symbol is displayed as '$' in the 'Pricing' page")
    public void verifyCurrencySymbols(){
    	
        Assert.assertTrue(pricingPage.areCurrencySymbolsDisplayed(), "Currency symbols are not displayed correctly.");
    	
    }
    
    @Then("I see the FAQ section contains {int} questions")
    public void verifyFAQCount(int expectedCount) {
        Assert.assertEquals(pricingPage.getFAQCount(), expectedCount, "FAQ count does not match.");
    }
}
