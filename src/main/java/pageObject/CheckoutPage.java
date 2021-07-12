package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CustomSeleniumMethods;

public class CheckoutPage extends CustomSeleniumMethods {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "input-payment-firstname")
    private WebElement paymentFirstNameField;

    @FindBy (id = "input-payment-lastname")
    private WebElement paymentLastNameField;

    @FindBy (id = "input-payment-company")
    private WebElement paymentCompanyNameField;

    @FindBy (id = "input-payment-address-1")
    private WebElement paymentAddressField;

    @FindBy (id = "input-payment-city")
    private WebElement paymentCityField;

    @FindBy (id = "input-payment-postcode")
    private WebElement paymentPostcodeField;

    @FindBy (xpath = "//input[@id='button-payment-address']")
    private WebElement continueAddressButton;

    @FindBy (xpath = "//input[@id='button-shipping-address']")
    private WebElement continueShippingButton;

    @FindBy (xpath = "//input[@id='button-shipping-method']")
    private WebElement continueShippingMethodButton;

    @FindBy (xpath = "//input[@id='button-payment-method']")
    private WebElement continuePaymentButton;

    @FindBy (xpath = "//select[@id='input-payment-zone']")
    private WebElement regionField;

    @FindBy (xpath = "//option[@value='3532']")
    private WebElement randomRegion;

    @FindBy (xpath = "//input[@name='agree']")
    private WebElement termsAgreeBox;

    @FindBy (xpath = "//input[@id='button-confirm']")
    private WebElement confirmButton;

    @FindBy (xpath = "//div[@id='content'][@class='col-sm-12']")
    private WebElement successContent;

    @FindBy (xpath = "//div[@class='pull-right']")
    private WebElement successContinueButton;

    public void enterPaymentAddressDetails(String firstName, String lastName, String company, String address, String city, String postCode){
        sendText(paymentFirstNameField, firstName);
        sendText(paymentLastNameField, lastName);
        sendText(paymentCompanyNameField, company);
        sendText(paymentAddressField, address);
        sendText(paymentCityField, city);
        sendText(paymentPostcodeField, postCode);

    }

    public void clickAddressContinue(){
        click(continueAddressButton);
    }
    public void clickShippingContinue(){
        click(continueShippingButton);
    }
    public void clickShippingMethodContinue(){
        click(continueShippingMethodButton);
    }
    public void clickPaymentContinue(){
        click(continuePaymentButton);
    }

    public void regionSelection(){
        click(regionField);
        click(randomRegion);
    }

    public void termsAgreement(){
        click(termsAgreeBox);
    }

    public void clickConfirmOrder(){
        click(confirmButton);
    }

    public String getSuccessContent(){
        waitForVisibility(successContinueButton);
        return getText(successContent);
    }

}
