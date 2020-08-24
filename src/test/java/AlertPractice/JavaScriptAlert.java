package AlertPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Driver;

public class JavaScriptAlert {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        // getDriver method returns WebDriver
        driver= Driver.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test(enabled = true)
    public void sweetAlertTest() throws InterruptedException {
        driver.get("https://sweetalert.js.org/");

        WebElement popup=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        popup.click();
        Thread.sleep(500);
        String actualMessage=driver.findElement(By.xpath("//div[contains(@class,'swal-text')]")).getText();
        String expectedMessage="Something went wrong!";
        Assert.assertEquals(actualMessage,expectedMessage,"Message is validated!");
        driver.findElement(By.xpath("//button[contains(.,'OK')]")).click(); //button[.='OK']
    }

    @Test(enabled = true)
    public void javascriptAlertTest1() throws InterruptedException {
        driver.navigate().to("https://sweetalert.js.org/");
        driver.findElement(By.xpath("//button[contains(@onclick,'alert')]")).click();
        Thread.sleep(500);
        // Since for javascript alert we do not have the webelement,
        // we need to switch driver to the alert class
        Alert alert=driver.switchTo().alert();
        // We have 4 method in Alert class to handle the js alerts.
        // 1- accept 2- dismiss-Cancel 3- sendKey 4- getText
        String actualJSMessage=alert.getText(); // will return text of alert

        String expectedJSMessage="Oops, something went wrong!";
        Assert.assertEquals(actualJSMessage,expectedJSMessage);
        alert.accept(); // it will click OK button in JS alert

    }

    @Test(enabled = true)
    public void jsSendKeyTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsButton=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsButton.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss(); // clicked the cancel button
        WebElement result=driver.findElement(By.id("result"));
        String actualResult=result.getText();
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);

        jsButton.click();
        alert.accept(); // clicked the Ok button
        String actualResult2=result.getText();
        String expectedResult2="You clicked: Ok";
        Assert.assertEquals(actualResult2,expectedResult2);



    }
    @Test(enabled = false)
    public void Test4(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("JavaScript");
        Assert.assertEquals(alert.getText(),"I am a JS prompt","Display Mesaage...");
        alert.accept();

        WebElement result=driver.findElement(By.id("result"));

        String actualResult3=result.getText();
        String expectedResult3="You entered: JavaScript";
        Assert.assertEquals(actualResult3,expectedResult3);

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        SoftAssert softAssert=new SoftAssert();
        alert.dismiss();
        softAssert.assertEquals(result.getText(),"You entered: null");
        softAssert.assertTrue(result.getText().endsWith("aa"));

        System.out.println("Techtorial Academy");
        softAssert.assertAll();
    }

    @Test(enabled = false)
    public void test2(){
        driver.navigate().to("https://the-internet.herokuapp.com/upload");


    }

}

