import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LinkedinHomePage;
import pages.LinkedinSearchPage;

import java.io.IOException;

public class LinkedInSearchPageTest extends BaseTest{

    @DataProvider
    public Object[][] validDataProvider(){
        return new Object[][]{
                {"wildseller91@rambler.ru"}
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void linkedInSearchPageUse(String userEmail) throws IOException, InterruptedException {

//        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page not loaded");
//        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail);
//        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home Page not loaded");
//        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.searchPage();
//        Assert.assertTrue(linkedinSearchPage.isPageLoaded()
//                && (linkedinSearchPage.getResultSize(linkedinSearchPage.getSearchList())>6),
//                "Search Page not loaded");
//        System.out.println(linkedinSearchPage.getResultSize(linkedinSearchPage.getSearchList()));
        System.out.println("Hear was out last test");
    }
}
