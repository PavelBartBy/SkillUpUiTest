import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigProperties;
import java.io.IOException;
import java.util.List;


public class TestUIPage {

    public static void main(String[] args) throws IOException {

        String webUrl = ConfigProperties.getProperty("webUrl");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver pdriver = new ChromeDriver();
        pdriver.get(webUrl);
        //Thread.sleep(5000);
        WebElement element = pdriver.findElement(By.cssSelector("[role='combobox']"));
        element.click();
        element.clear();
        element.sendKeys("Selenium");
        element.sendKeys(Keys.ENTER);

        List <WebElement> searchResult = pdriver.findElements(By.xpath("//div[@class='rc']"));
        if (searchResult.size()==9){
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
        pdriver.quit();

    }

}
