package WindowPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsIntro {
    WebDriver driver;

    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(); // it will open your driver
        // maximize and fullscreen
        driver.manage().window().maximize();


    }

    @Test
    public void test1(){

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement clickHereButton=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click(); // this button will open new window
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        String parentPageId=driver.getWindowHandle(); // This method will return String for page id
        System.out.println(parentPageId);

        // getWindowHandles --> Set<String>
        Set<String> pageIds=driver.getWindowHandles();
        // switchTo() and window(PageId)
        for(String id : pageIds){
            if(!id.equals(parentPageId)){
                driver.switchTo().window(id);
            }
            System.out.println("After switching title: "+driver.getTitle());
            System.out.println("After switching url: "+driver.getCurrentUrl());
       //     System.out.println(id);
            // If you do not switch to new window, you can not use the new window
            // Once you switch to the new window, you can not use the parent window
            // unless you switch back to parent
            driver.switchTo().window(parentPageId);
            clickHereButton.click();
        }
    }

    @Test
    public void test2(){
        driver.get("http://www.popuptest.com/popuptest12.html");
        String currrentPageId=driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();
        System.out.println(ids);
        //TASK
        // close all the popup if they are not equals to your currentpage
        for(String id:ids){
            if(!id.equals(currrentPageId)){// it will switch to driver to new window if id is not equals to parent id
                driver.switchTo().window(id);
                driver.close(); // it will close your current window
            }
        }

        driver.switchTo().window(currrentPageId); // it will switch back to your first window
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());

    }

    @Test
    public void test3(){
        driver .get("http://www.popuptest.com/popuptest1.html");
        String parentId=driver.getWindowHandle();
         // Close all window if they are not equals to your first page
           BrowserUtils.closeWindows(driver,parentId);


    }


//    @Test
//    public void test1() {
//        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
//        clickHereButton.click();// this button will open new window
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        // this method will return String for page id
//        String parentPageId = driver.getWindowHandle();
//        System.out.println(parentPageId);
//        // getWindowHandles--> Set<String>
//        Set<String> pageIds = driver.getWindowHandles();
//        // switchTo() and window(PageId)
//        for (String id : pageIds) {
//            if (!id.equals(parentPageId)) {
//                driver.switchTo().window(id);
//            }
//        }
//        System.out.println("After switching title: "+driver.getTitle());
//        System.out.println("After switching url: "+driver.getCurrentUrl());
//        // If you do not switch to new window, you can not use the new window
//        // Once you switch to the new window, you can not use the parent window
//        // unless you switch back to parent
//        driver.switchTo().window(parentPageId);
//        clickHereButton.click();
//    }
}
