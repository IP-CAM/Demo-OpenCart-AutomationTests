package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class OrderHistoryPage extends CustomSeleniumMethods {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@data-original-title='View']")
    private WebElement viewItemButton;

    @FindBy (xpath = "//a[@data-original-title='Return']")
    private WebElement returnItemButton;

    public void openItem(){
        click(viewItemButton);
    }

    public void clickOnReturnItem(){
        click(returnItemButton);
    }
}
