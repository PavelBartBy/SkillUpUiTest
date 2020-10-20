
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LinkedinHomePage;
import pages.LinkedinLoginPage;

import java.io.IOException;


public class LinkedInLoginTest extends BaseTest{

    @DataProvider
    public Object[][] validDataProvider(){
        return new Object[][]{
                {"wildseller91@rambler.ru"}
        };
    }

    /***
     * Test for Login Page on LinkedIn
     *
     * Preconditions:
     * - open new browser window
     * - navigate to url
     *
     * Scenario:
     * - Verified that Login Page is loaded
     * - create Home Page after successful login
     * - verified that Home Page is loaded
     *
     * @param loginEmail - Email used as login
     * @throws IOException - exception for input/output problems
     */
    @Test(dataProvider ="validDataProvider")
    public void linkedinLoginTest(String loginEmail) throws IOException {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(loginEmail);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home Page not loaded");
        System.out.println("sss");
    }

    /***
     * Test for Login Page on LinkedIn with empty login field
     *
     * Preconditions:
     * - open new browser window
     * - navigate to url
     *
     * Scenario:
     * - Verified that Login Page is loaded
     * - input empty string for login field
     * - input validate password for pass field
     * - check result for login process
     *
     * Expected Result:
     * - test finished on Login Page after timeout
     *
     * @throws IOException - exception for input/output problems
     */
    @Test()
    public void emptyUserEmailFieldTest() throws IOException {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page not loaded");
        Object page = linkedinLoginPage.login("");
        if (page instanceof LinkedinLoginPage){
            Assert.assertTrue(((LinkedinLoginPage) page).isPageLoaded(), "Log Page not loaded");
        } else {
            Assert.assertTrue(((LinkedinHomePage) page).isPageLoaded(), "Home Page not loaded");
        }
    }
}
