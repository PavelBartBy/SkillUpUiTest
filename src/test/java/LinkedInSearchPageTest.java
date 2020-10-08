import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedinHomePage;
import pages.LinkedinSearchPage;

import java.io.IOException;

public class LinkedInSearchPageTest extends BaseTest{

    @Test
    public void linkedInSearchPageUse() throws IOException, InterruptedException {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home Page not loaded");
        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.searchPage();
        Assert.assertTrue(linkedinSearchPage.isPageLoaded()
                && (linkedinSearchPage.getResultSize(linkedinSearchPage.getSearchList())>6),
                "Search Page not loaded");
        System.out.println(linkedinSearchPage.getResultSize(linkedinSearchPage.getSearchList()));
    }
}
