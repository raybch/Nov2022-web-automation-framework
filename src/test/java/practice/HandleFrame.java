package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleFrame {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @Test
    public void test() throws InterruptedException {
        driver.switchTo().frame("courses-iframe");
        System.out.println("switch to iFrame success");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Job Support']")).click();
        Thread.sleep(3000);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
