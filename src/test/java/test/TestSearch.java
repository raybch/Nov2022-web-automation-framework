package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utility.ReadFromExcel;
import utility.Utility;

import java.io.File;

public class TestSearch extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestSearch.class.getName());
    ReadFromExcel read = new ReadFromExcel("C:\\Users\\PNT\\IdeaProjects\\Nov2022AutomationFramework\\data\\titles.xlsx", "test data");

    @Test
    public void searchJavaBook() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());

        String expectedTitle = read.getCellValueForGivenHeaderAndKey("key","home page title");
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("land to amazon webpage success");

        homePage.typeItemToSearch("java book");
        homePage.clickOnSearchButton();

        String expectedTitle2 = read.getCellValueForGivenHeaderAndKey("key","java search title");
        String actualTitle2 = getCurrentTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);
        LOG.info("java search title validation success");
    }
    @Test
    public void searchSeleniumBook() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());

        String expectedHomePageTitle = read.getCellValueForGivenHeaderAndKey("key","home page title");
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
        LOG.info("land to amazon webpage success");

        homePage.typeItemToSearch("selenium book");
        homePage.clickOnSearchButton();

        String expectedSearchPageTitle = read.getCellValueForGivenHeaderAndKey("key","selenium search title");
        String actualSearchPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedSearchPageTitle, actualSearchPageTitle);
        LOG.info("java search title validation success");
    }
    @Test
    public void searchJava(){
        HomePage homePage = new HomePage(getDriver());

        String expectedHomePageTitle = read.getCellValueForGivenHeaderAndKey("key","home page title");
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
        LOG.info("land to amazon webpage success");

        homePage.selectOptionFromMenuDropdown("Books");
        homePage.searchItem("java");

        String expectedSearchPageTitle = read.getCellValueForGivenHeaderAndKey("key","java book search title");
        String actualSearchPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedSearchPageTitle, actualSearchPageTitle);
        LOG.info("java search title validation success");
    }
}
