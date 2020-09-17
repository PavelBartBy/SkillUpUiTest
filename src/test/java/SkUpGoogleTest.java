import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.ConfigProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkUpGoogleTest {

    @Test
    public void searchSomeDataGoogleForm() throws InterruptedException, IOException {

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

        List<WebElement> searchResult = wdriver.findElements(By.xpath("//div[@class='rc']"));

        List<Boolean> toCheck = new ArrayList<Boolean>();

        for (WebElement result : searchResult){
            String textFromSearchResult = result.getText();
            if (textFromSearchResult.contains("Selenium")) {
                toCheck.add(true);
            } else {
                toCheck.add(false);
            }
        }
        System.out.println(toCheck);
        System.out.println (searchResult.size());
        Thread.sleep(3000);
        wdriver.quit();

    }
    @Test
    public void searchSomeDataYandexForm() throws IOException, InterruptedException {

        String webUrl = ConfigProperties.getProperty("webUrl2");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver wdriver = new ChromeDriver();
        wdriver.get(webUrl);
        WebElement element = wdriver.findElement(By.className("input__control"));
        element.click();
        element.clear();
        element.sendKeys("Selenium");
        element.sendKeys(Keys.ENTER);

        List<WebElement> searchResult = wdriver.findElements(By.className("serp-item"));
        System.out.println (searchResult.size());
        Thread.sleep(3000);
        wdriver.quit();

    }
}
