package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    protected WebElement waitUntilElementVisible(WebElement element, int seconds){

        WebDriverWait wait =new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected void assertElementVisible (WebElement element, int seconds, String message) {
        try{
            waitUntilElementVisible(element,seconds);
        } catch (TimeoutException exception){
            throw new AssertionError(message);
        }
    }

    public void waitPageNavigation(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        System.out.println("Done wait");
    }

}
