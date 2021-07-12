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
    public void userIsAtProductDetails() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFirstFeaturedItem();

        productDetailsName = driver.getTitle();
    }
    @When("User click on Add to Cart button")
    public void userClickOnAddToCartButton() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
    }
    @Then("Item is successfully added to the cart")
    public void itemIsSuccessfullyAddedToCart() {
        String expectedMessage = "You have added " +productDetailsName+ " to your shopping cart!";
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        boolean isItemAdded = productDetailsPage.getAlertMessage().contains(expectedMessage);
        Assert.assertTrue(isItemAdded);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
