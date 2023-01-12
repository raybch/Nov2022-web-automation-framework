package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestSearch extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestSearch.class.getName());

    @Test
    public void searchJavaBook() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());

        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("land to amazon webpage success");

        homePage.typeItemToSearch("java book");
        homePage.clickOnSearchButton();

        String expectedTitle2 = "Amazon.com : java book";
        String actualTitle2 = getCurrentTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);
        LOG.info("java search title validation success");
    }
    //@Test
    public void searchSeleniumBook() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());

        String expectedHomePageTitle = "Amazon.com. Spend less. Smile more.";
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
        LOG.info("land to amazon webpage success");

        homePage.typeItemToSearch("selenium book");
        homePage.clickOnSearchButton();

        String expectedSearchPageTitle = "Amazon.com : selenium book";
        String actualSearchPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedSearchPageTitle, actualSearchPageTitle);
        LOG.info("java search title validation success");
    }
    //@Test
    public void searchJava(){
        HomePage homePage = new HomePage(getDriver());

        String expectedHomePageTitle = "Amazon.com. Spend less. Smile more.";
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
        LOG.info("land to amazon webpage success");

        homePage.selectOptionFromMenuDropdown("Books");
        homePage.searchItem("java");

        String expectedSearchPageTitle = "Amazon.com : java";
        String actualSearchPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedSearchPageTitle, actualSearchPageTitle);
        LOG.info("java search title validation success");
    }
}
