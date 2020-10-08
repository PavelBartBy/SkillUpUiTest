package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected String getCurrentTitle(){
        return driver.getTitle();
    }

    protected boolean isUrlContains(String urlPart, int seconds){
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
