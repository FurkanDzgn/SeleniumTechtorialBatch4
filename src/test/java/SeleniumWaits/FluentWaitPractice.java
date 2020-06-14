package SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitPractice {

    WebDriver driver;

    @Test(enabled = true)
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

        // withTimeout(Duration.ofSeconds(20)) --> total number of sec which we are going to wait
        // pollingEvery(Duration.ofSeconds(2)) --> it will try to interact with Webelement every 2 sec.
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(RuntimeException.class);

        WebElement message=wait.until(
                driver -> driver.findElement(By.id("message"))
//                new Function<WebDriver, WebElement>() {
//                    @Override
//                    public WebElement apply(WebDriver driver) {
//                        return driver.findElement(By.id("message"));
//                    }
//                }
        );

        String actualMessage=message.getText();
        String expectedMessage="It's gone!";
        Assert.assertEquals(actualMessage,expectedMessage);

        // Task click add button and using fluentWait wait until "It's back!" message element interactable

        WebElement addButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        addButton.click();

        message=wait.until(
                driver ->driver.findElement(By.id("message"))
        );

        String actualMessage2=message.getText();
        String expectedMessage2="It's back!";
        Assert.assertEquals(actualMessage2,expectedMessage2);

    }

    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

  //    By mess=By.id("message");                                                   // mess
        // if there is a frequency to load the webelement on the page
        // it will better to use the fluentwait and try to interact with webelement in specified time period
        WebElement message= BrowserUtils.fluentWait(driver,20,2,By.id("message"));

        System.out.println(message.getText());
    }
}
