import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigProperties;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class TestUIPage {

    public static void main(String[] args) throws IOException, InterruptedException {

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
        //pdriver.quit();



    }

//    public static int sizeOf(Class dataType) {
//
//        if (dataType==null) throw new NullPointerException();
//        if (dataType==int.class || dataType==Integer.class) return 4;
//        if (dataType==byte.class || dataType==Byte.class) return 1;
//        if (dataType==long.class || dataType==Long.class) return 8;
//        if (dataType==float.class || dataType==Float.class) return 4;
//        if (dataType==double.class || dataType==Double.class) return 8;
//        if (dataType==boolean.class || dataType==Boolean.class) return 4; //wo BitSet
//        if (dataType==char.class || dataType==Character.class) return 2;
//        if (dataType==String.class) return 5; //+ 2 on ev simbol
//        return 8;
//    }

}
