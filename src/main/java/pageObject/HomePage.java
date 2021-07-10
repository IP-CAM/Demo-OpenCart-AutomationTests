package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class HomePage extends CustomSeleniumMethods {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@title='My Account']")
    private WebElement myAccountButton;

    @FindBy (xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
    private WebElement registerButton;

    @FindBy (xpath = "//a[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy (xpath = "//input[@placeholder='Search']")
    private WebElement searchBarField;

    @FindBy (xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchButton;

    public void clickOnMyAccount(){
        click(myAccountButton);
    }

    public void clickOnRegister(){
        click(registerButton);
    }

    public void clickOnLogin(){
        click((loginButton));
    }

    public void enterSearchText(String searchText) {
        sendText(searchBarField, searchText);
    }

    public void clickOnSearchButton(){
        click(searchButton);
    }
}
