package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class CategoryPage extends CustomSeleniumMethods {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//body/div[@id='product-category']/div[@class='row']/div[@id='content']/div[4]/div[1]/div[1]")
    private WebElement firstItemOfCategory;

    @FindBy (xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]")
    private WebElement itemDetailsButton;

    public void openFirstItemOfCategory(){
        click(firstItemOfCategory);
    }

    public void openItemDetails(){
        scroll(itemDetailsButton);
        click(itemDetailsButton);
    }
}
