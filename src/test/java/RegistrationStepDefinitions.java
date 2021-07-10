import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.RegistrationPage;
import util.CustomSeleniumMethods;
import util.GenerateRandomString;

public class RegistrationStepDefinitions {

    WebDriver driver;
    public static String email, password;

    @Given("user is at register page")
    public void user_is_at_register_page() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnRegister();
    }

    @When("user enters valid {string}, {string}, email, {string} and password")
    public void user_enters_valid_data(String firstName, String lastName, String telephone) {
        //Calling random string generator, because if we hardcode the email, we would fail every time after first attempt
        GenerateRandomString rng = new GenerateRandomString();
        email = rng.getRandomString() + "@mailinator.com";
        password = rng.getRandomString();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterRegistrationData(firstName, lastName, email, telephone, password, password);
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());
    }

    @When("choose if he wants to accept newsletter")
    public void choose_if_he_wants_to_accept_newsletter() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.acceptingNewsletter();
    }

    @When("agree with privacy policy")
    public void agree_with_privacy_policy() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.acceptingPrivacyPolicy();
    }

    @When("clicks on continue button")
    public void clicks_on_continue_button() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickContinue();
    }

    @Then("user should see the success message")
    public void userShouldSeeTheSuccessMessage() {
        CustomSeleniumMethods.takeScreenshot(driver, getClass().getSimpleName().toString());

        boolean pageSource = driver.getPageSource().contains("Your Account Has Been Created!");
        Assert.assertTrue(pageSource);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
