package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserInit {

    protected static final String URL = "https://demo.opencart.com/";
    private static final int TIMEOUT = 15;
    private WebDriver driver;

    public WebDriver startChrome(){

        //Downloading driver
        WebDriverManager.chromedriver().setup();

        //Managing desired capabilities of our browser
        ChromeOptions chromeOptions = new ChromeOptions();

        //If set to true, tests will be run in the Headless mode
        //chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        return driver;
    }

    public WebDriver startFirefox(){

        //Downloading driver
        WebDriverManager.firefoxdriver().setup();

        //Managing desired capabilities of our browser
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");

        //If set to true, tests will be run in the Headless mode
        //firefoxOptions.setHeadless(false);

        driver = new FirefoxDriver(firefoxOptions);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        return driver;
    }
}
