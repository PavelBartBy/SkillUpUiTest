package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.io.IOException;

public class LinkedinLoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement userElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(xpath = "//button[@data-litms-control-urn='login-submit']")
    private WebElement enterButtonElement;

    @FindBy(id = "password-visibility-toggle")
    private WebElement visibilityToggle;

    @FindBy(id = "rememberMeOptIn-checkbox")
    private WebElement rememberMeCheckbox;

    @FindBy(id ="learn_more")
    private WebElement learnMoreLink;

    @FindBy(id ="sign-in-with-google-button")
    private WebElement googleSignInButton;

    @FindBy(xpath = ".//*[@class='btn__tertiary--medium action__btn mercado-button--tertiary']")
    private WebElement forgetPasswordLink;

    @FindBy(id ="join_now")
    private WebElement registrationLink;

    @FindBy(className = "language-selector__button")
    private WebElement languageSelectorButton;


    public LinkedinLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        assertElementVisible(userElement, "Web element not visible ");
    }

    public void loginFieldInput(String loginEmail) {
        userElement.click();
        userElement.clear();
        userElement.sendKeys(loginEmail);
    }

    public void passFieldInput() {
        passwordElement.click();
        passwordElement.clear();
        try {
            passwordElement.sendKeys(ConfigProperties.getProperty("pass"));
        } catch (IOException e){
            System.out.println("Input parameter from Properties - failed");
            logger.debug("Input parameter from Properties - failed");
        }
    }

    public <T> T login(String loginEmail) {
        this.loginFieldInput(loginEmail);
        this.passFieldInput();
        this.clickEnterButton();
        if (isUrlContains("/feed")){
            return (T) new LinkedinHomePage(driver, wait);
        } else {
            return (T) this;
        }


    }

    public void clickEnterButton(){
        enterButtonElement.click();
    }

    public boolean isPageLoaded() {
        System.out.println(getCurrentUrl()+"  "+getCurrentTitle());
        return getCurrentUrl().contains("login")
                && getCurrentTitle().contains("LinkedIn");


    }
}
