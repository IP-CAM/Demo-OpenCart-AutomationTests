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
    public void userAddedProductToCart() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();

        HomePage homePage = new HomePage(driver);
        homePage.hoverSecondDropDown();
        homePage.clickOnSeeAllDropDown();

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.openItemDetails();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
    }

    @When("User proceed to the checkout")
    public void userProceededToCheckout() {
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

    @And("User enter {string}, {string}, {string}, {string}, {string}, {string}, and choose country and region, and press continue")
    public void userEnterMandatoryData(String firstName, String lastName, String company, String address, String city, String postcode) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterPaymentAddressDetails(firstName, lastName, company, address, city, postcode);
        checkoutPage.regionSelection();
        checkoutPage.clickAddressContinue();
    }

    @And("choose delivery address and clicks on continue")
    public void chooseDeliveryAddressAndClickContinue() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickShippingContinue();
    }

    @And("select delivery method and clicks on continue")
    public void selectDeliveryMethodAndClickContinue() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickShippingMethodContinue();
    }

    @And("select payment method and accept the terms")
    public void selectPaymentMethodAndAcceptTerms() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.termsAgreement();
        checkoutPage.clickPaymentContinue();
    }

    @And("confirm the order")
    public void confirmOrder() throws InterruptedException {
        Thread.sleep(5000);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickConfirmOrder();
    }

    @Then("His or her order will be placed")
    public void orderIsPlaced() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        boolean isPurchaseDone = checkoutPage.getSuccessContent().contains("Your order has been successfully processed!");
        Assert.assertTrue(isPurchaseDone);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
