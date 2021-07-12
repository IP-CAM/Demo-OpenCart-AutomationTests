import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.RegistrationPage;
import util.GenerateRandomString;

public class RegistrationStepDefinitions{

    public static String email, password;
    WebDriver driver;

    @Given("user is at register page")
    public void userIsAtRegisterPage() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.clickOnRegister();
    }

    @When("user enters valid {string}, {string}, email, {string} and password")
    public void userEnterValidData(String firstName, String lastName, String telephone) {
        //Calling random string generator, because if we hardcode the email, we would fail every time after first attempt
        GenerateRandomString rng = new GenerateRandomString();
        email = rng.getRandomString() + "@mailinator.com";
        password = rng.getRandomString();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterRegistrationData(firstName, lastName, email, telephone, password, password);
    }

    @And("choose if he wants to accept newsletter")
    public void chooseNewsletter() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.acceptingNewsletter();
    }

    @And("agree with privacy policy")
    public void privacyAgree() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.acceptingPrivacyPolicy();
    }

    @And("clicks on continue button")
    public void clickOnContinue() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickContinue();
    }

    @Then("user should see the success message")
    public void userShouldSeeTheSuccessMessage() {
        boolean pageSource = driver.getPageSource().contains("Your Account Has Been Created!");
        Assert.assertTrue(pageSource);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
