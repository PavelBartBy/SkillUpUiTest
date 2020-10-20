package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends BasePage {

    @FindBy(xpath=".//*[@class='neptune-grid two-column']")
    WebElement searchResultField;

    @FindBy(xpath = ".//*[@data-test-search-result='JYMBII']")
    private List<WebElement> searchList;

    @FindBy(css = "[type='like-icon']")
    private WebElement likeIcon;

    public LinkedinSearchPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait =wait;
        PageFactory.initElements(driver,this);
        assertElementVisible(searchResultField, "Result Field is not visible");
    }

    public List<String> getSearchList(){

        List<String> result = new ArrayList<>();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
        assertElementVisible(likeIcon, "LikeIcon is not visible");
        for (WebElement element :searchList) {
            result.add(element.toString());
        }
        return result;
    }

    public int getResultSize(List<String> resultList){
        return resultList.size();
    }

    public boolean isPageLoaded() {

        return getCurrentUrl().contains("search");
    }
}
