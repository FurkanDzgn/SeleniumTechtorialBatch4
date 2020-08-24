package IFramePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;
import java.util.Set;

public class IFrameIntro {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement textBox=driver.findElement(By.id("tinymce"));
        System.out.println(textBox.getText());

   //     driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        // it will switch the driver from iframe to default html
        WebElement header=driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());

    }

    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // want to switch my frame with the frame name
        // Nested frame: first we switch to parent frame
        driver.switchTo().frame("frame-top"); // nested1
        // after parent frame we switch to child frame
        driver.switchTo().frame("frame-middle"); // nested2
        WebElement middle=driver.findElement(By.id("content"));
        System.out.println(middle.getText());

        // parentFrame switch to parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(. ,'RIGHT')]"));
        System.out.println(right.getText());



    }

    @Test
    public void test3(){
        driver.get("https://skpatro.github.io/demo/iframes/");

        String parentPage=driver.getWindowHandle();
        driver.switchTo().frame("Framename1");
                                                           //a[.='Category2']
        WebElement category2=driver.findElement(By.xpath("//a[contains(. , 'Category2')]"));
        category2.click();

//        BrowserUtils.closeWindows(driver,"basicjava");
//        System.out.println(driver.getTitle());

        BrowserUtils.switchWindowByUrl(driver,"basicjava");
        System.out.println(driver.getTitle());

//        Set<String > ids=driver.getWindowHandles();
//        for(String id:ids){
//            if(!id.equals(parentPage)){
//                driver.switchTo().window(id);
//                System.out.println(driver.getTitle());
//
//            }
//
//       //    System.out.println(driver.getTitle());
//       }

        // come back to your main page
        // and click category3
//        driver.switchTo().window(parentPage);
//        driver.switchTo().frame("Frame2");
//        WebElement category3=driver.findElement(By.xpath("//a[contains(. , 'Category3')]"));
//        category3.click();
//        BrowserUtils.closeWindows(driver,"softwaretesting/");
//        System.out.println(driver.getTitle());

//        BrowserUtils.switchWindowByTitle(driver,"iframes");
//        driver.switchTo().frame(1);
//        WebElement category3=driver.findElement(By.xpath("//a[.='Category3')]"));
//        category3.click();


        driver.switchTo().window(parentPage);
        WebElement frm=driver.findElement(By.xpath("//iframe[@id='Frame2']"));
        driver.switchTo().frame(frm);
        WebElement category3=driver.findElement(By.xpath("//a[contains(.,'Category3')]"));
        category3.click();
        BrowserUtils.closeWindows(driver,parentPage);
        System.out.println(driver.getTitle());
  //      driver.close();



    }

    @Test
    public void test4(){
        driver.get("https://www.selenium.dev/selenium/docs/api/java/");
        WebElement frameElement=driver.findElement(By.xpath("//frame[@name='packageListFrame']"));

        driver.switchTo().frame(frameElement);
        List<WebElement> packageNames=driver.findElements(By.xpath("//a[@target='packageFrame']"));
        for(WebElement packageName : packageNames){
            System.out.println(packageName.getText());

        }

    }
}
