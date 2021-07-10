package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class MyAccountPage extends CustomSeleniumMethods {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutButton;

    @FindBy (xpath = "//a[normalize-space()='Change your password']")
    private WebElement changePasswordButton;

    @FindBy (id = "input-password")
    private WebElement inputPasswordField;

    @FindBy (id = "input-confirm")
    private WebElement confirmPasswordField;

    @FindBy (xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    public void clickOnLogout(){
        click(logoutButton);
    }

    public void clickOnPassword(){
        click(changePasswordButton);
    }

    public void changePassword(String password){
        sendText(inputPasswordField, password);
        sendText(confirmPasswordField, password);
        click(continueButton);
    }
}
