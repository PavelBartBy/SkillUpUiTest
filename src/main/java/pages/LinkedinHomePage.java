package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinHomePage extends BasePage{

    @FindBy(id ="ember8")
    WebElement searchField;
    @FindBy(id ="ember20")
    WebElement homePageButton;
    @FindBy(id ="ember23")
    WebElement networkButton;
    @FindBy(id ="ember26")
    WebElement vacancyButton;
    @FindBy(id ="ember29")
    WebElement messageButton;
    @FindBy(id ="ember32")
    WebElement notificationButton;
    @FindBy(id ="ember35")
    WebElement profileButton;
    @FindBy(id ="ember40")
    WebElement linkedinAppsButton;
    @FindBy(id ="ember45")
    WebElement postAJobButton;
    @FindBy(xpath =".//*[@data-ember-action-3416='3416']")
    WebElement sharePostButton;

    public LinkedinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        assertElementVisible(messageButton, 5, "Message button not visible");

    }

    public void messageClick(){
        messageButton.click();
    }
}
