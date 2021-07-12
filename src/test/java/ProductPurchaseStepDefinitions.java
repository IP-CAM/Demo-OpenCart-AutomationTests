import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.*;

public class ProductPurchaseStepDefinitions {

    WebDriver driver;

    @Given("User added the product to the cart")
    public void user_added_the_product_to_the_cart() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();

        HomePage homePage = new HomePage(driver);
        homePage.hoverSecondDropDown();
        homePage.clickOnSeeAllDropDown();

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.openFirstItemOfCategory();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
    }

    @When("User proceed to the checkout")
    public void user_proceed_to_the_checkout() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickOnCart();
        productDetailsPage.goToCheckout();
    }

    @And("User logs in")
    public void userLogsIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterData(RegistrationStepDefinitions.email, RegistrationStepDefinitions.password);
        loginPage.clickOnLogin();
    }

    @When("User enter {string}, {string}, {string}, {string}, {string}, {string}, and choose country and region, and press continue")
    public void user_enter_and_choose_country_and_region_and_press_continue(String firstName, String lastName, String company, String address, String city, String postcode) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterPaymentAddressDetails(firstName, lastName, company, address, city, postcode);
        checkoutPage.regionSelection();
        checkoutPage.clickAddressContinue();
    }

    @When("choose delivery address and clicks on continue")
    public void choose_delivery_address_and_clicks_on_continue() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickShippingContinue();
    }

    @When("select delivery method and clicks on continue")
    public void select_delivery_method_and_clicks_on_continue() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickShippingMethodContinue();
    }

    @When("select payment method and accept the terms")
    public void select_payment_method_and_accept_the_terms() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.termsAgreement();
        checkoutPage.clickPaymentContinue();
    }

    @When("confirm the order")
    public void confirm_the_order() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickConfirmOrder();
    }

    @Then("His or her order will be placed")
    public void his_or_her_order_will_be_placed() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        boolean isPurchaseDone = checkoutPage.getSuccessContent().contains("Your order has been successfully processed!");
        Assert.assertTrue(isPurchaseDone);
    }

    @After
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
