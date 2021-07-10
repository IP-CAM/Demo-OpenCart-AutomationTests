package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class LoginPage extends CustomSeleniumMethods {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "input-email")
    private WebElement inputEmail;

    @FindBy (id = "input-password")
    private WebElement inputPassword;

    @FindBy (xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public void enterData(String email, String password){
        sendText(inputEmail, email);
        sendText(inputPassword, password);
    }
    public void clickOnLogin(){
        click(loginButton);
    }
}
