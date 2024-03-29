package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class RegistrationPage extends CustomSeleniumMethods {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

    @FindBy(name = "newsletter")
    WebElement acceptingNewsletterButton;

    @FindBy(name = "agree")
    WebElement agreePrivacyPolicyButton;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    public void enterRegistrationData (String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
        sendText(firstNameField, firstName);
        sendText(lastNameField, lastName);
        sendText(emailField, email);
        sendText(telephoneField, telephone);
        sendText(passwordField, password);
        sendText(passwordConfirmField, confirmPassword);
    }

    public void acceptingNewsletter(){
        click(acceptingNewsletterButton);
    }

    public void acceptingPrivacyPolicy(){
        click(agreePrivacyPolicyButton);
    }

    public void clickContinue(){
        click(continueButton);
    }
}
