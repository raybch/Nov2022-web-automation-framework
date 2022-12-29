package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FirstTest {

    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chromedriver", "C:\\Users\\PNT\\IdeaProjects\\untitled\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        System.out.println("land to amazon webpage success");
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("title validation success");

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        System.out.println("text sent success");
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("click search success");
        String expectedTitle2 = "Amazon.com : java book";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);
        System.out.println("java search title validation success");
    }
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium book");
        System.out.println("text sent success");
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("click search success");
        String expectedTitle2 = "Amazon.com : selenium book";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);
        System.out.println("java search title validation success");
    }
    @Test
    public void test3(){
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Books");
        System.out.println("Books option selected from the dropdown");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        System.out.println("text sent success");
        String expectedTitle2 = "Amazon.com : java";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);
        System.out.println("java search title validation success");
    }
}
