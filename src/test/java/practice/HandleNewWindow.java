package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HandleNewWindow {
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
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String newWin = it.next();
        driver.switchTo().window(newWin);
        System.out.println("switch to new window success");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
        System.out.println(driver.getTitle());
        driver.switchTo().window(parent);
        //driver.findElement(By.xpath("//button[@id='openwindow']")).click();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
