package SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitPractice {

    WebDriver driver;

    @Test(enabled = false)
    public void test1(){
        WebDriverManager.chromedriver().setup(); // chromedriver
        driver=new ChromeDriver();
        // pageLoadTimeout method will take 2 parameter,
        // one is time as long num, second parameter is file for timeUnit
        // it will wait the page until is is loaded for 10 sec
        // pageLoadTimeout is dynamic wait, if the PAGE loaded in 3 sec rest of 7 sec will be ignored
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // implicitlyWait will wait all your WEBELEMENT which your driver is pointing
        // implicitlyWait throws NoSuchElementException if the element is not available
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        // it will wait for an asynchronous script in your page
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");

    }

    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        // every 250 milsec it will try to find your element until 10 sec
        // implicitlyWait will wait all the webelements which my driver is pointing.
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

        WebElement idMessage=driver.findElement(By.id("message"));
        String actualText=idMessage.getText();
        String expectedText="It's gone!";

        Assert.assertTrue(idMessage.isDisplayed());
        Assert.assertEquals(actualText,expectedText);

    }

}
