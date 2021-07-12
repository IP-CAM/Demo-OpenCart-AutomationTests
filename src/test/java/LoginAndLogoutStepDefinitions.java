import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
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
    public void userIsAtLoginPage() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnLogin();
    }

    @When("User enters username and password")
    public void userEnterUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterData(RegistrationStepDefinitions.email, RegistrationStepDefinitions.password);
    }

    @And("Clicks on login button")
    public void clickOnLoginButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLogin();
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("My Account", pageTitle);
    }

    @Given("User is at My Account page")
    public void userIsAtMyAccountPage() {
        userShouldBeLoggedIn();
    }

    @When("User clicks on logout button")
    public void userClickOnLogoutButton() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnLogout();
    }

    @Then("User should be logged out")
    public void userShouldBeLoggedOut() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Account Logout", pageTitle);
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
