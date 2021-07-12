import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.ProductDetailsPage;
import pageObject.WishListPage;

public class WishListProductsStepDefinitions {

    WebDriver driver;
    private String itemName;

    LoginAndLogoutStepDefinitions loginAndLogoutStepDefinitions = new LoginAndLogoutStepDefinitions();

    @Given("User is logged in")
    public void user_is_logged_in() {

        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();

        loginAndLogoutStepDefinitions.login(driver);
    }

    @Given("User is at product details page")
    public void user_is_at_product_details_page() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnHomeButton();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFirstFeaturedItem();
    }

    @When("User clicks on heart icon")
    public void user_clicks_on_icon() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        itemName = driver.getTitle();
        productDetailsPage.clickOnWishListButton();
    }

    @Then("The item is added to the wish list")
    public void the_item_is_added_to_the_wish_list() {
        String expectedMessage = "Success: You have added " +itemName+ " to your wish list!";
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        boolean isItemAdded = productDetailsPage.getAlertMessage().contains(expectedMessage);
        Assert.assertTrue(isItemAdded);
        teardown();
    }

    @When("User clicks on Wish List button in the header")
    public void user_clicks_on_wish_list_button_in_the_header() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnWishListButtonHeader();
    }

    @When("Clicks on the X button at the item")
    public void clicks_on_the_x_button_at_the_item() {
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.deleteFirstItem();
    }

    @Then("The product is removed from the wish list")
    public void the_product_is_removed_from_the_wish_list() {
        boolean pageSource = driver.getPageSource().contains(itemName);
        Assert.assertFalse(pageSource);
    }

    @After
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
