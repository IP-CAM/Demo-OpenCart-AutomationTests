import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import util.CustomSeleniumMethods;

public class LoginAndLogoutStepDefinitions {

    WebDriver driver;

    public WebDriver login(WebDriver driver){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterData(RegistrationStepDefinitions.email, RegistrationStepDefinitions.password);
        loginPage.clickOnLogin();

        return driver;
    }

    @Given("User is at login page")
    public void user_is_at_login_page() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnLogin();
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterData(RegistrationStepDefinitions.email, RegistrationStepDefinitions.password);
    }

    @When("Clicks on login button")
    public void clicks_on_login_button() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLogin();
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());
    }

    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("My Account", pageTitle);
    }

    @Given("User is at My Account page")
    public void user_is_at_my_account_page() {
        user_should_be_logged_in();
    }

    @When("User clicks on logout button")
    public void user_clicks_on_logout_button() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnLogout();
    }

    @Then("User should be logged out")
    public void user_should_be_logged_out() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Account Logout", pageTitle);
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
