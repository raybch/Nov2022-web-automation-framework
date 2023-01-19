package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ParseInteger {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://phptravels.com/demo");
    }
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        String number1 = driver.findElement(By.cssSelector("#numb1")).getText();
        String number2 = driver.findElement(By.cssSelector("#numb2")).getText();
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        int total = num1 + num2;
        driver.findElement(By.cssSelector("#number")).sendKeys(String.valueOf(total));
        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
