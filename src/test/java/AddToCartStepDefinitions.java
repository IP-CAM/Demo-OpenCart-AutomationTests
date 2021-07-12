import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.ProductDetailsPage;

public class AddToCartStepDefinitions {

    WebDriver driver;
    private String productDetailsName;

    @Given("User is at the product details")
    public void user_is_at_the_product_details() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFirstFeaturedItem();

        productDetailsName = driver.getTitle();
    }
    @When("User click on Add to Cart button")
    public void user_click_on_add_to_cart_button() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
    }
    @Then("Item is successfully added to the cart")
    public void item_is_successfully_added_to_the_cart() {
        String expectedMessage = "You have added " +productDetailsName+ " to your shopping cart!";
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        boolean isItemAdded = productDetailsPage.getAlertMessage().contains(expectedMessage);
        Assert.assertTrue(isItemAdded);
    }

    @After
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
