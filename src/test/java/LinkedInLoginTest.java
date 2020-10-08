
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedinHomePage;
import java.io.IOException;


public class LinkedInLoginTest extends BaseTest{

    @Test()
    public void linkedinLoginTest() throws IOException, InterruptedException {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page not loaded");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home Page not loaded");

    }

}
