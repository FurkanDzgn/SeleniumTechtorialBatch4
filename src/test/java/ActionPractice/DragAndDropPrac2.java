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

import java.util.concurrent.TimeUnit;

public class DragAndDropPrac2 {

    WebDriver driver;

    // It will run after everything in this class
    // location is not important
    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("This is after class annotation");
        Thread.sleep(5000);
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        System.out.println("Test1 is running");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement blueBox=driver.findElement(By.className("test1"));
        WebElement orangeBox=driver.findElement(By.className("test2"));

        Thread.sleep(1000);

        //drag and drop only with Action class
        String actual=blueBox.getText();
        String expected="Drag the small circle here ...";
        Assert.assertEquals(actual,expected,"Default text for blueBox is failed.");

        String actual2=orangeBox.getText();
        String expected2="... Or here."; // expected is coming from business Req.
        Assert.assertEquals(actual2,expected2,"Default text for orangeBox is failed.");


    }

    @Test
    public void test2(){
        System.out.println("Test2 is running");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement blueBox=driver.findElement(By.className("test1"));
        WebElement orangeBox;

        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,blueBox).perform();

        String expectedBlueBoxText="You did great!";
        blueBox=driver.findElement(By.className("test1"));
        String actualBlueBoxText=blueBox.getText();
        Assert.assertEquals(actualBlueBoxText,expectedBlueBoxText,"After dropping blue box message is failed");

        String expectedOrangeBoxText="(Drop here)";
        orangeBox=driver.findElement(By.className("test2"));
        String actualOrangeBoxText=orangeBox.getText();
        Assert.assertEquals(actualOrangeBoxText,expectedOrangeBoxText,"After dropping blue box, Orange box message is failed");
    }

    @Test
    public void test3(){
        System.out.println("Test3 is running");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement blueBox;
        WebElement orangeBox=driver.findElement(By.className("test2"));

        Actions actions=new Actions(driver);
        // this process for moving circle inside the orange box
        actions.clickAndHold(source).moveToElement(orangeBox).release().perform();

        orangeBox=driver.findElement(By.className("test2"));
        String expectedOrangeResult="You did great!";
        String actualOrangeResult=orangeBox.getText();
        // StateElementException --> if the element is not available in your DOM,selenium will throw StateElementException
        Assert.assertEquals(actualOrangeResult,expectedOrangeResult);

        blueBox=driver.findElement(By.className("test1"));
        String actualBlueResult=blueBox.getText();
        String expectedBlueResult="(Drop here)";
        Assert.assertEquals(actualBlueResult,expectedBlueResult);

    }

    // It will run before everything in this class
    // location is not important
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.out.println("This is before class annotation");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();

        // How we can use implicitly wait. It takes two parameter(int value,TimeUnits)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // It will wait 5 sec until the elements are loaded in the page
        // If you are not able to find the element after 5 sec. Selenium will throw NoSuchElementException.
    }

}
