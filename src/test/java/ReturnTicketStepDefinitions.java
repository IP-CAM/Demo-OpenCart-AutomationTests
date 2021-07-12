import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.MyAccountPage;
import pageObject.OrderHistoryPage;
import pageObject.ProductReturnsPage;

public class ReturnTicketStepDefinitions {

    WebDriver driver;

    LoginAndLogoutStepDefinitions loginAndLogoutStepDefinitions = new LoginAndLogoutStepDefinitions();

    @Given("User is logged in and has placed order")
    public void userIsLoggedAndPlacedOrder() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();

        loginAndLogoutStepDefinitions.login(driver);
    }

    @When("User goes to order history")
    public void userGoesToOrderHistory() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.openViewOrderHistory();
    }

    @And("Opens order that he or she wants to return")
    public void openDesiredOrder() {
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.openItem();
    }

    @And("Clicks on return button")
    public void clickOnReturnButton() {
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.clickOnReturnItem();
    }

    @And("Select a reason for return")
    public void selectAReasonForReturn() {
        ProductReturnsPage productReturnsPage = new ProductReturnsPage(driver);
        productReturnsPage.selectReasonForReturn();
    }

    @And("Clicks on submit button")
    public void clicksOnSubmitButton() {
        ProductReturnsPage productReturnsPage = new ProductReturnsPage(driver);
        productReturnsPage.clickOnSubmit();
    }

    @Then("Return request is created")
    public void returnRequestIsCreated() {
        ProductReturnsPage productReturnsPage = new ProductReturnsPage(driver);
        boolean isSubmitSuccessful = productReturnsPage.getSuccessContent().contains("Thank you for submitting your return request.");
        Assert.assertTrue(isSubmitSuccessful);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
