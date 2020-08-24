package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropPractice {

    @Test
    public void test1() throws InterruptedException {

        // 1. user webdriver Manager
        WebDriverManager.chromedriver().setup();
        // instantiate object
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //intantate the Actions object

        // fullscreen for mac
        // maximize for windows
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(@id,'onetrust-a')]")).click();
   //     driver.findElement(By.className("optanon-allow-all accept-cookies-button")).submit();
        Actions actions=new Actions(driver);

        Thread.sleep(1000);
        WebElement source=driver.findElement(By.id("draggable"));
        Thread.sleep(1000);
        WebElement target=driver.findElement(By.id("droptarget"));
        String actualText=target.getText();
        String expectedText="Drag the small circle here.";
        // Message will display When the assertion failed
        Thread.sleep(1000);
        Assert.assertEquals(actualText,expectedText,"Expected and actual is not matching");

        // 8 Locators --> name, id, xpath, css selector, classname, TagName, linktext, PartialLinkText
        // Use dragAndDrop method
        Thread.sleep(1000);
        actions.dragAndDrop(source,target).perform();
        // make the assertion to validate the Actions in UI
        //Assertion After Drag and Drop
        Thread.sleep(1000);
        String expectedDropText="You did great!";
        String actualDropText=target.getText();
        System.out.println(actualDropText);
        Assert.assertTrue(expectedDropText.equals(actualDropText),"after drop text is not matching");



    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        Actions actions=new Actions(driver);
        // clickAndHold -- moveToElement -- relase -- perform()

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        Thread.sleep(1000);
        actions.clickAndHold(source).moveToElement(target).perform();
        actions.release(target).perform();

   //     actions.clickAndHold(source).moveToElement(target).release().perform();

        //  actions.release().perform();
        // release() --> will release the mouse in current location of mouse
        // release(source) --> will release the mouse in target location

    }

//    WebDriver driver;
//
//    @BeforeClass
//    public void setUp() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
//        driver.manage().window().maximize();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
//    }
//
//
//    @Test
//    public void test3() throws InterruptedException {
//
//        WebElement source=driver.findElement(By.id("draggable"));
//        WebElement blueBox=driver.findElement(By.className("test1"));
//        WebElement orangeBox=driver.findElement(By.className("test2"));
//
//        Thread.sleep(1000);
//
//        String actual=blueBox.getText();
//        String expected="Drag the small circle here ...";
//        Assert.assertEquals(actual,expected,"Default text for blueBox is failed.");
//
//        String actual2=orangeBox.getText();
//        String expected2="... Or here."; // expected is coming from business Req.
//        Assert.assertEquals(actual2,expected2,"Default text for orangeBox is failed.");
//
//
//        Actions actions=new Actions(driver);
//        actions.dragAndDrop(source,blueBox).perform();
//
//        blueBox=driver.findElement(By.className("test1"));
//        String expectedBlueBoxText="You did great!";
//        String actualBlueBoxText=blueBox.getText();
//        Assert.assertEquals(actualBlueBoxText,expectedBlueBoxText,"After dropping blue box message is failed");
//
//        orangeBox=driver.findElement(By.className("test2"));
//        String expectedOrangeBoxTest="(Drop here)";
//        String actualOrangeBoxTest=orangeBox.getText();
//        Assert.assertEquals(actualOrangeBoxTest,expectedOrangeBoxTest,"After dropping blue box,orange box is failed");
//
//
//
//
//    }
//
//    @Test
//    public void test4(){
//
//        WebElement source=driver.findElement(By.id("draggable"));
//        WebElement blueBox=driver.findElement(By.className("test1"));
//        WebElement orangeBox;
//
//        Actions actions=new Actions(driver);
//        actions.dragAndDrop(source,blueBox).perform();
//
//        String expectedBlueBoxText="You did great!";
//        blueBox=driver.findElement(By.className("test1"));
//        String actualBlueBoxText=blueBox.getText();
//        Assert.assertEquals(actualBlueBoxText,expectedBlueBoxText,"After dropping blue box message is failed");
//
//        String expectedOrangeBoxText="(Drop here)";
//        orangeBox=driver.findElement(By.className("test2"));
//        String actualOrangeBoxText=orangeBox.getText();
//        Assert.assertEquals(actualOrangeBoxText,expectedOrangeBoxText,"After dropping blue box, Orange box message is failed");
//    }
//
//    @Test
//    public void test5(){
//
//        WebElement source=driver.findElement(By.id("draggable"));
//        WebElement blueBox;
//        WebElement orangeBox=driver.findElement(By.className("test2"));
//
//        Actions actions=new Actions(driver);
//        // this process for moving circle inside the orange box
//        actions.clickAndHold(source).moveToElement(orangeBox).release().perform();
//
//        orangeBox=driver.findElement(By.className("test2"));
//        String expectedOrangeResult="You did great!";
//        String actualOrangeResult=orangeBox.getText();
//        // StateElementException --> if the element is not available in your DOM,selenium will throw StateElementException
//        Assert.assertEquals(actualOrangeResult,expectedOrangeResult);
//
//
//        blueBox=driver.findElement(By.className("test1"));
//        String actualBlueResult=blueBox.getText();
//        String expectedBlueResult="(Drop here)";
//        Assert.assertEquals(actualBlueResult,expectedBlueResult);
//
//    }
//
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }



}
