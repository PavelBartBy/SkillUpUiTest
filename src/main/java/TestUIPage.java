import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigProperties;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestUIPage {

    public static void main(String[] args) throws IOException, InterruptedException {

        String webUrl = ConfigProperties.getProperty("webUrl");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver wdriver = new ChromeDriver();
        wdriver.get(webUrl);
        WebElement element = wdriver.findElement(By.cssSelector("[role='combobox']"));
        element.click();
        element.clear();
        element.sendKeys("Selenium");
        element.sendKeys(Keys.ENTER);

        List <WebElement> searchResult = wdriver.findElements(By.xpath("//div[@class='rc']"));
        if (searchResult.size()==9){
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }

        List<Boolean> toCheck = new ArrayList<Boolean>();

        for (WebElement result : searchResult){
            String textFromSearchResult = result.getText();
            if (textFromSearchResult.contains("Selenium")) {
                toCheck.add(true);
            } else {
                toCheck.add(false);
                }
            }
        for (Boolean result : toCheck){
            System.out.println(result);
        }

        Thread.sleep(3000);
        wdriver.quit();
    }
}
