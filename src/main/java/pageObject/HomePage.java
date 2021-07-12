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

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]")
    private WebElement firstFeaturedItem;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[4]")
    private WebElement fourthFeaturedItem;

    @FindBy (xpath = "//div[4]//div[1]//div[2]//h4[1]")
    private WebElement fourthFeaturedItemName;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement firstItemOnSearch;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h4[1]")
    private WebElement firstItemOnSearchName;

    @FindBy (xpath = "//a[@id='wishlist-total']//i[@class='fa fa-heart']")
    private WebElement wishListButtonHeader;

    @FindBy (xpath = "//body/div/nav[@id='menu']/div/ul/li[2]")
    private WebElement secondDropDown;

    @FindBy (xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
    private WebElement seeAllDropDownButton;


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

    public String getNameOfFourthItem() {
        String text = getText(fourthFeaturedItemName);
        return text;
    }
    public void clickOnFourthItem () {
        click(fourthFeaturedItem);
    }

    public String getNameOfFirstItemOfSearch() {
        String text = getText(firstItemOnSearchName);
        return text;
    }

    public void clickOnFirstItemOfSearch(){
        click(firstItemOnSearch);
    }

    public void clickOnWishListButtonHeader(){
        click(wishListButtonHeader);
    }

    public void clickOnFirstFeaturedItem(){
        click(firstFeaturedItem);
    }

    public void hoverSecondDropDown(){
        hover(secondDropDown);
    }

    public void clickOnSeeAllDropDown(){
        click(seeAllDropDownButton);
    }
}
