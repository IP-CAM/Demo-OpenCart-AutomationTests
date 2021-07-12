package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class ProductDetailsPage extends CustomSeleniumMethods {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[@data-original-title='Add to Wish List']")
    private WebElement wishListButton;

    @FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement alertMessage;

    @FindBy (xpath = "//button[@id='button-cart']")
    private WebElement addToCartButton;

    @FindBy (xpath = "//div[@id='content']//div[@class='row']")
    private WebElement itemContent;

    @FindBy (id = "cart")
    private WebElement cartButton;

    @FindBy (xpath = "//strong[normalize-space()='Checkout']")
    private WebElement checkoutButton;

    public String getProductDetailsContent(){
        String text = getText(itemContent);
        return text;
    }

    public void clickOnWishListButton(){
        click(wishListButton);
    }

    public String getAlertMessage(){
        return getText(alertMessage);
    }

    public void addToCart(){
        scroll(addToCartButton);
        click(addToCartButton);
    }

    public void clickOnCart(){
        click(cartButton);
    }

    public void goToCheckout(){
        click(checkoutButton);
    }
}
