package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class WishListPage extends CustomSeleniumMethods {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//tbody/tr[1]/td[6]/a[1]")
    private WebElement firstDeleteButton;

    @FindBy (xpath = "//div[@class='table-responsive']")
    private WebElement wishListTable;

    public void deleteFirstItem(){
        click(firstDeleteButton);
    }

    public String getContentFromTable(){
        return getText(wishListTable);
    }
}
