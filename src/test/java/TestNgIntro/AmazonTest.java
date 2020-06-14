package TestNgIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iphone");

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        Thread.sleep(500);
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle="Amazon.com : iphone"; // business requirement
        Assert.assertEquals(actualTitle, expectedTitle);






    }
}
