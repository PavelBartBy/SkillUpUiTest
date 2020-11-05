package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class with generals and standard methods
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    final static Logger logger = (Logger) LogManager.getLogger(BasePage.class.getName());

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected String getCurrentTitle(){
        return driver.getTitle();
    }

    protected boolean isUrlContains(String urlPart){
        try {
            return wait.until(ExpectedConditions.urlContains(urlPart));
        } catch (TimeoutException e){
            System.out.println("Requested url is missing-%"+ urlPart);
            return false;
        }
    }

    protected WebElement waitUntilElementVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void assertElementVisible (WebElement element, String message) {
        try{
            waitUntilElementVisible(element);
        } catch (TimeoutException exception){
            throw new AssertionError(message);
        }
    }
}
