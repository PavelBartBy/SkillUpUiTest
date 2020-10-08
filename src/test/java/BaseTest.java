import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LinkedinLoginPage;
import utils.ConfigProperties;
import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    private static final int timeToWaitSec = 10;
    LinkedinLoginPage linkedinLoginPage;

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(String browserName) throws IOException {

        switch (browserName){
            case "Chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(optionsChrome);
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
        wait = new WebDriverWait(driver,timeToWaitSec);
        String webUrl = ConfigProperties.getProperty("webUrl3");
        driver.get(webUrl);
        linkedinLoginPage = new LinkedinLoginPage(driver,wait);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        driver.quit();
    }
}
