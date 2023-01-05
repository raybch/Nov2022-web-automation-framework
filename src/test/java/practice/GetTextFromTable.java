package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GetTextFromTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @Test
    public void test(){
        String text = driver.findElement(By.xpath("//*[text()='Web Table Example']/following-sibling::table/tbody/tr[11]/td[2]")).getText();
        System.out.println(text);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
