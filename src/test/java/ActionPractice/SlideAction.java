package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.Test;

public class SlideAction {

    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        // moveByOffset --> it will move the mouse from current location to provided location
        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(slider)
                .moveByOffset(-55,0)
                .release()
                .perform();
   //    System.out.println(slider.getAttribute("value"));

        //Task --> keep moving to the slider if the slider if the value is not equals to 5.

        Thread.sleep(1000);
   //     driver.quit();
//        int x=10;
//        while (!slider.getAttribute("value").equals("5")){
//            actions.clickAndHold(slider)
//                    .moveByOffset(x,0)
//                    .release()
//                    .perform();
//            x=x+10;
//            Thread.sleep(1000);
//        }

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        WebElement number=driver.findElement(By.id("range"));
        Actions actions=new Actions(driver);
        int xOffSet=-55;
        // - --------- - =5
        // -55 ........ 55
        while(!number.getText().equals("5")) {

            actions.clickAndHold(slider)
                    .moveByOffset(xOffSet, 0)
                    .release()
                    .perform();
            xOffSet+=10; // compound assignment in Java
            Thread.sleep(1000);

        }
    }

    @Test
    public void Test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        WebElement number=driver.findElement(By.id("range"));

        Actions actions=new Actions(driver);
        actions.clickAndHold(slider).perform();
        // how can I slider left to right without using moveByOffset
        while ((!number.getText().equals("5"))){
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            Thread.sleep(1000);
        }

    }

    @Test
    public void test4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/keyboard-navigation");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        Thread.sleep(1000);
        WebElement first=driver.findElement(By.xpath("//a[contains(@style,'left: -8px')]"));
        WebElement second=driver.findElement(By.xpath("//a[contains(@style,'left: 190px')]"));

        Point point=first.getLocation();
        int xCord = point.getX();
        int yCord = point.getY();
        System.out.println(xCord);
        System.out.println(yCord);
        //701-899=198
        Point point1=second.getLocation();
        System.out.println(point1.getX());
        System.out.println(point1.getY());

        Actions actions=new Actions(driver);
        //first element left to right
        actions.clickAndHold(first).moveByOffset(200,0).release().perform();
        Thread.sleep(1000);
        actions.clickAndHold(second).moveByOffset(-200,0).release().perform();
    }

    @Test
    public void test5() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        Thread.sleep(1000);

        WebElement vertical=driver.findElement(By.xpath("//a[@style='bottom: -8px;']"));
        //a[@style='bottom:  -8px;']

        WebElement ten=driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='10']"));
        WebElement zero=driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='0']"));

        Point tenY=ten.getLocation();
        System.out.println(tenY.getY());
        Point zeroY=zero.getLocation();
        System.out.println(zeroY.getY());
        System.out.println(tenY.getY()-zeroY.getY());
        // 453-541=-88

        Actions actions=new Actions(driver);
        actions.clickAndHold(vertical).moveByOffset(0,-88).release().perform();
        actions.clickAndHold(vertical).moveByOffset(0,44).release().perform();
    }
}
