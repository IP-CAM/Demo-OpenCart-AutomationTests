import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import util.CustomSeleniumMethods;

public class SearchProductsStepDefinitions {

    WebDriver driver;

    @Given("User is at the web shop")
    public void user_is_at_the_web_shop() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
    }
    @When("User enters product name in the search bar")
    public void user_enters_product_name_in_the_search_bar() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchText("iPhone");
        homePage.clickOnSearchButton();
    }
    @When("Users press enter or search button")
    public void users_press_enter_or_search_button() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearchButton();
    }
    @Then("Results of the search are shown")
    public void results_of_the_search_are_shown() {
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Search - iPhone", pageTitle);
    }

    @After
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
