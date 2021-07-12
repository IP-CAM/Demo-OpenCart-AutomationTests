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
    public void userIsAtHomePage() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
    }

    @When("User clicks on the featured item")
    public void userClickOnFeaturedItem() {
        HomePage homePage = new HomePage(driver);
        featureItemName = homePage.getNameOfFourthItem();
        homePage.clickOnFourthItem();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        featureItemDetailsName = productDetailsPage.getProductDetailsContent().contains(featureItemName);
    }

    @Then("the details of the product is opened")
    public void detailsAreOpen() {
        Assert.assertTrue(featureItemDetailsName);
    }

    @Given("user searches for product via search bar")
    public void userSearchesForProductViaSearchBar() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchText("iMac");
        homePage.clickOnSearchButton();
    }

    @When("user successfully finds the product and clicks on it")
    public void userFindsProductAndClicksOnIt() {
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
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
