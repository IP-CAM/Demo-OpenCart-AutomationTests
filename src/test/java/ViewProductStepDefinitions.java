import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.ProductDetailsPage;

public class ViewProductStepDefinitions {

    WebDriver driver;
    private String featureItemName, searchItemName;
    private boolean featureItemDetailsName, searchItemDetailsName;

    @Given("User is at the home page")
    public void user_is_at_the_home_page() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
    }

    @When("User clicks on the featured item")
    public void user_clicks_on_the_featured_item() {
        HomePage homePage = new HomePage(driver);
        featureItemName = homePage.getNameOfFourthItem();
        homePage.clickOnFourthItem();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        featureItemDetailsName = productDetailsPage.getProductDetailsContent().contains(featureItemName);
    }

    @Then("the details of the product is opened")
    public void the_details_of_the_product_is_opened() {
        Assert.assertTrue(featureItemDetailsName);
    }

    @Given("user searches for product via search bar")
    public void user_searches_for_product_via_search_bar() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchText("iMac");
        homePage.clickOnSearchButton();
    }

    @When("user successfully finds the product and clicks on it")
    public void user_successfully_finds_the_product_and_clicks_on_it() {
        HomePage homePage = new HomePage(driver);
        searchItemName = homePage.getNameOfFirstItemOfSearch();
        homePage.clickOnFirstItemOfSearch();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        searchItemDetailsName = productDetailsPage.getProductDetailsContent().contains(searchItemName);
    }

    @Then("the details of the searched product is opened")
    public void theDetailsOfTheSearchedProductIsOpened() {
        Assert.assertTrue(searchItemDetailsName);
    }

    @After
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }

}
