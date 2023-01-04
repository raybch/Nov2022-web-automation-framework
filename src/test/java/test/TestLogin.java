package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin extends CommonAPI {
    
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());

    @Test
    public void invalidEmailAddress() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        homePage.hoverOverFloatingMenu(getDriver());
        homePage.clickOnLoginButton();

        String title = getCurrentTitle();
        Assert.assertEquals(title, "Amazon Sign-In");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("abcdefg@gmail");
        loginPage.clickOnConnectButton();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "There was a problem");
        LOG.info("error message validation success");
    }
}
