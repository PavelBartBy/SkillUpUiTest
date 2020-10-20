import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LinkedinLoginPage;
import utils.ConfigProperties;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    private static final int timeToWaitSec = 10;
    LinkedinLoginPage linkedinLoginPage;

    final static Logger logger = (Logger) LogManager.getLogger(BaseTest.class.getName());


    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(@Optional("Chrome") String browserName) throws IOException {

        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(optionsChrome);
        logger.debug("Hello");

//        switch (browserName){
//            case "Chrome":
//                ChromeOptions optionsChrome = new ChromeOptions();
//                optionsChrome.addArguments("--start-maximized");
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver(optionsChrome);
//                break;
//            case "Firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                driver.manage().window().maximize();
//                break;
//        }
        wait = new WebDriverWait(driver,timeToWaitSec);
        String webUrl = ConfigProperties.getProperty("webUrl3");
        driver.get(webUrl);
        linkedinLoginPage = new LinkedinLoginPage(driver,wait);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){

        String path = String.format("./screenshots/%s.png", result.getName());
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(path), true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        driver.quit();
        logger.info("Test finished");
    }
}
