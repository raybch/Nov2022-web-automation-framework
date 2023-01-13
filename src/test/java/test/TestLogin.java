package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utility.ConnectDB;

public class TestLogin extends CommonAPI {
    
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());

    @Test
    public void invalidEmailAddress() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        String email = ConnectDB.getTableColumnData("select * from cred","password").get(0);

        homePage.hoverOverFloatingMenu(getDriver());
        homePage.clickOnLoginButton();

        String title = getCurrentTitle();
        Assert.assertEquals(title, "Amazon Sign-In");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress(email);
        loginPage.clickOnConnectButton();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "There was a problem");
        LOG.info("error message validation success");
    }
}
