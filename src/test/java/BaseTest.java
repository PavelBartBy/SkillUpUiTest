import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LinkedinHomePage;
import pages.LinkedinLoginPage;
import utils.ConfigProperties;
import java.io.IOException;

public class BaseTest {

    WebDriver wdriver;
    LinkedinLoginPage linkedinLoginPage;
    LinkedinHomePage linkedinHomePage;

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(String browserName) throws IOException {

        switch (browserName){
            case "Chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--start-maximized");
                WebDriverManager.chromedriver().setup();
                wdriver = new ChromeDriver(optionsChrome);
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                wdriver = new FirefoxDriver();
                wdriver.manage().window().maximize();
                break;
        }

        String webUrl = ConfigProperties.getProperty("webUrl3");
        wdriver.get(webUrl);

        linkedinLoginPage = new LinkedinLoginPage(wdriver);
        linkedinLoginPage.loginFieldInput();
        linkedinLoginPage.passFieldInput();
        linkedinLoginPage.clickEnterButton();
        linkedinLoginPage.waitPageNavigation(8);

        linkedinHomePage = new LinkedinHomePage(wdriver);
        linkedinHomePage.messageClick();
        linkedinHomePage.waitPageNavigation(8);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        wdriver.quit();
    }
}
