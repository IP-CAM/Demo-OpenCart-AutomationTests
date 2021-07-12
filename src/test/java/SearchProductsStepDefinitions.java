import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;

public class SearchProductsStepDefinitions {

    WebDriver driver;

    @Given("User is at the web shop")
    public void userIsAtWebShop() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
    }

    @When("User enters product name in the search bar")
    public void userEnterProductNameInSearchBar() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchText("iPhone");
        homePage.clickOnSearchButton();
    }

    @And("Users press enter or search button")
    public void userPressEnterOrSearchButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearchButton();
    }

    @Then("Results of the search are shown")
    public void resultsOfTheSearchAreShown() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Search - iPhone", pageTitle);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
