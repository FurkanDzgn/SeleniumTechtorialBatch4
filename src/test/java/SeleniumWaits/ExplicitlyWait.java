package SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.lang.reflect.GenericArrayType;

public class ExplicitlyWait {

    WebDriver driver;

    @Test(enabled = true)
    public void test1(){
    //    System.setProperty("driver","location");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

        //It takes 2 argument, one is driver, another one is int num of sec
        // explicitly wait will wait for specific element and provided condition
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement idMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

 //       WebElement idMessage=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));
        String actualText=idMessage.getText();
        String expectedText="It's gone!";
        Assert.assertEquals(actualText,expectedText);


        WebElement addButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        addButton.click();
        // explicitlywait for loading
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        

        String actualText1=driver.findElement(By.id("message")).getText();
        String expectedText1="It's back!";
        Assert.assertEquals(actualText1,expectedText1);

        // What will happen if I use 10 sec for implicitly wait
        // and use 20 sec explicitly wait
        // According to selenium documentation,website the result will be unpredictable.
    }

    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

        WebElement message= BrowserUtils.visibilityOfElementLocator(driver,10,By.id("message"));
        System.out.println(message.getText());
    }
}
