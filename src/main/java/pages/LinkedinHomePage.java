package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LinkedinHomePage extends BasePage{

    @FindBy(css = "[role='combobox']")
    WebElement searchField;
    @FindBy(id ="ember29")
    WebElement messageButton;
    @FindBy(xpath =".//*[@data-ember-action-3416='3416']")
    WebElement sharePostButton;

    public LinkedinHomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait =wait;
        PageFactory.initElements(driver,this);
        assertElementVisible(messageButton, "Message button not visible");
    }

    public void messageClick(){
        messageButton.click();
    }

    public void searchFieldActivation(){
        searchField.click();
        searchField.sendKeys("Gates");
        searchField.sendKeys(Keys.ENTER);
    }
    public LinkedinSearchPage searchPage(){
        searchFieldActivation();
        return new LinkedinSearchPage(driver,wait);
    }

    public boolean isPageLoaded() {
        return getCurrentTitle().contains("LinkedIn");
    }
}
