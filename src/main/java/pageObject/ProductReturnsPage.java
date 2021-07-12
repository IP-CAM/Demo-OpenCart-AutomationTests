package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class ProductReturnsPage extends CustomSeleniumMethods {

    public ProductReturnsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@value='3']")
    private WebElement reasonForReturn3;

    @FindBy (xpath = "//input[@value='Submit']")
    private WebElement submitButton;

    @FindBy (xpath = "//a[normalize-space()='Continue']")
    private WebElement successContinueButton;

    @FindBy (xpath = "//div[@id='content']")
    private WebElement successContent;

    public void selectReasonForReturn(){
        click(reasonForReturn3);
    }

    public void clickOnSubmit(){
        click(submitButton);
    }

    public String getSuccessContent(){
        waitForVisibility(successContinueButton);
        return getText(successContent);
    }
}
