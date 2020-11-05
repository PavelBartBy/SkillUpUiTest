import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LinkedinHomePage;
import pages.LinkedinSearchPage;
import utils.ConfigProperties;

import java.io.IOException;

public class LinkedInSearchPageTest extends BaseTest{

    @DataProvider
    public Object[][] validDataProvider() throws IOException {
        return new Object[][]{
                {ConfigProperties.getProperty("login")}
        };
    }

    /***
     * Test for Search Page on LinkedIn
     *
     * Preconditions:
     * - open new browser window
     * - navigate to url
     *
     * Scenario:
     * - Verified that Login Page is loaded
     * - input validate login and password
     * - check result for login process
     * - activate search and input data
     * - check result
     *
     * Expected Result:
     * - test finished with result size >6
     */
    @Test(dataProvider = "validDataProvider")
    public void linkedInSearchPageUse(String userEmail) {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home Page not loaded");
        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.searchPage();
        Assert.assertTrue(linkedinSearchPage.isPageLoaded()
                && (linkedinSearchPage.getResultSize(linkedinSearchPage.getSearchList())>6),
                "Search Page not loaded");
        System.out.println(linkedinSearchPage.getResultSize(linkedinSearchPage.getSearchList()));
        System.out.println("Hear was out last test");
    }
}
