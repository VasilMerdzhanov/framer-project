package stepdefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import utils.BaseSetup;
//
//public class Hooks {

//    @Before
//    public void setup() {
//        BaseSetup.getDriver().get("https://mind-wend-913065.framer.app/");
//    }
//
//    @After
//    public void tearDown() {
//        BaseSetup.quitDriver();
//    }
//}
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import utils.BaseSetup;

public class Hooks {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = BaseSetup.getDriver();
    }

    @AfterClass
    public void tearDown() {
        BaseSetup.quitDriver();
    }
}