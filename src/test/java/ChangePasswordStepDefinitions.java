import driver.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.MyAccountPage;

public class ChangePasswordStepDefinitions {

    WebDriver driver;

    LoginAndLogoutStepDefinitions loginAndLogoutStepDefinitions = new LoginAndLogoutStepDefinitions();

    @Given("User is on My Account page")
    public void userIsOnMyAccountPage() {
        BrowserInit browserInit = new BrowserInit();
        driver = browserInit.startChrome();
        loginAndLogoutStepDefinitions.login(driver);
    }

    @When("User click on password")
    public void userClickOnPassword() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnPassword();
    }

    @And("Enter {string}, confirm it and clicks on continue")
    public void enterNewPasswordAndConfirmItAndClickOnContinue(String newPassword) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.changePassword(newPassword);
        RegistrationStepDefinitions.password = newPassword;
        boolean pageSource = driver.getPageSource().contains("Success: Your password has been successfully updated.");
        Assert.assertTrue(pageSource);
    }

    @And("User tries to login with new password")
    public void userTriesToLoginWithNewPassword() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnLogout();
        loginAndLogoutStepDefinitions.login(driver);
    }

    @Then("User can successfully login")
    public void userCanSuccessfullyLogin() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("My Account", pageTitle);
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
