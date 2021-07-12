package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CustomSeleniumMethods {

    WebDriver driver;
    public WebDriverWait wait;
    private static final int TIMEOUT = 15;

    public CustomSeleniumMethods(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibility(WebElement element){
        wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click (WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendText (WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public static void takeScreenshot(WebDriver driver, String className){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot_"+className+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText (WebElement element){
        waitForVisibility(element);
        return element.getText();
    }

    public void hover (WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

}
