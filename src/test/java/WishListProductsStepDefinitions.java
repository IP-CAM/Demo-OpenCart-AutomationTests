import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
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
    public void userIsLoggedIn() {

        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();

        loginAndLogoutStepDefinitions.login(driver);
    }

    @Given("User is at product details page")
    public void userIsAtProductDetailsPage() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnHomeButton();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFirstFeaturedItem();
    }

    @When("User clicks on heart icon")
    public void userClicksOnHeartIcon() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        itemName = driver.getTitle();
        productDetailsPage.clickOnWishListButton();
    }

    @Then("The item is added to the wish list")
    public void itemIsAddedToTheWishList() {
        String expectedMessage = "Success: You have added " +itemName+ " to your wish list!";
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        boolean isItemAdded = productDetailsPage.getAlertMessage().contains(expectedMessage);
        Assert.assertTrue(isItemAdded);
        driver.close();
    }

    @When("User clicks on Wish List button in the header")
    public void userClicksOnWishListButtonInHeader() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnWishListButtonHeader();
    }

    @And("Clicks on the X button at the item")
    public void clicksOnXButtonAtItem() {
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.deleteFirstItem();
    }

    @Then("The product is removed from the wish list")
    public void productIsRemovedFromWishList() {
        boolean pageSource = driver.getPageSource().contains(itemName);
        Assert.assertFalse(pageSource);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
