package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ComponentsPage;
import utils.BaseSetup;

public class ComponentsStepDefinitions {
	WebDriver driver;
	WebDriverWait wait;
    ComponentsPage componentsPage = new ComponentsPage(BaseSetup.getDriver());

    
    @Given("the Framer site is loaded")
    public void the_framer_site_is_loaded() {
    	BaseSetup.getDriver();
    }
    
    @When("I scroll to 'Many types of components to customize' in the components page")
    public void scrollToManyTypesSection() {
        componentsPage.scrollToManyTypesSection();
    }

    @Then("I see the 'visit' button is displayed on each card in the 'Many types of components to customize' section")
    public void verifyVisitButtons() {
        Assert.assertTrue(componentsPage.areVisitButtonsDisplayed(), "Not all 'Visit' buttons are displayed.");
    }

    @And("I scroll to the bottom of the components page")
    public void scrollToSignUpButton() {
        componentsPage.scrollToSignUpButton();
    }

    @And("I see a 'Sign Up' button in the subscribe section")
    public void verifySignUpButtonPresence() {
        Assert.assertNotNull(componentsPage.getSignUpButtonColor(), "'Sign Up' button is not present.");
    }

    @Then("I see the 'Sign Up' button's color as 'rgb(255,82,79)'")
    public void verifySignUpButtonColor() {
        Assert.assertEquals(componentsPage.getSignUpButtonColor(), "rgb(255, 82, 79)", "Sign Up button's color is incorrect.");
    }

    @Then("I see the 'Download' button")
    public void verifyDownloadButton() {
        Assert.assertTrue(componentsPage.isDownloadButtonDisplayed(), "'Download' button is not displayed.");
    }
    
    @Then("I see the Components page is displayed")
    public void i_see_the_components_page_is_displayed() {
    	Assert.assertTrue(componentsPage.isComponentsPageDisplayed(), "Not all 'Visit' buttons are displayed.");
    }
    
}

