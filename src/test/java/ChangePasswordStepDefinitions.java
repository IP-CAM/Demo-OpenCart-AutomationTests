import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.MyAccountPage;
import util.CustomSeleniumMethods;

public class ChangePasswordStepDefinitions {

    WebDriver driver;

    LoginAndLogoutStepDefinitions loginAndLogoutStepDefinitions = new LoginAndLogoutStepDefinitions();

    @Given("User is on My Account page")
    public void user_is_at_my_account_page() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
        loginAndLogoutStepDefinitions.login(driver);
    }

    @When("User click on password")
    public void user_click_on_password() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnPassword();
    }

    @And("Enter {string}, confirm it and clicks on continue")
    public void enter_new_password_and_confirm_it_and_clicks_on_continue(String newPassword) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.changePassword(newPassword);
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());
        RegistrationStepDefinitions.password = newPassword;
        boolean pageSource = driver.getPageSource().contains("Success: Your password has been successfully updated.");
        Assert.assertTrue(pageSource);
    }

    @And("User tries to login with new password")
    public void user_tries_to_login_with_new_password() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnLogout();
        loginAndLogoutStepDefinitions.login(driver);
    }

    @Then("User can successfully login")
    public void user_can_successfully_login() {
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());
        String pageTitle = driver.getTitle();
        Assert.assertEquals("My Account", pageTitle);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
