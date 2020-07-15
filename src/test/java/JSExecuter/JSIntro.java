package JSExecuter;

import Tests.TestBase;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class JSIntro extends TestBase {

    @Test(enabled = false)
    public void test1() throws InterruptedException {
        driver.get("https://www.techtorialacademy.com/");
        // first we need to cast our driver to JSexecuter
        JavascriptExecutor jsExecuter=(JavascriptExecutor) driver;


        String title=jsExecuter.executeScript("return document.title").toString();
        System.out.println(title);
        WebElement browseCourse=driver.findElement(By.xpath("//a[.='Browse Course']"));

        jsExecuter.executeScript("arguments[0].click()",browseCourse);


        title=jsExecuter.executeScript("return document.title").toString();
        System.out.println(title);

        jsExecuter.executeScript("alert('Techtorial Academy JSExecuter Test')");

        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement getStarted=driver.findElement(By.xpath("//h4[.='On-Campus Course']/following-sibling::div/a"));
        Thread.sleep(2000);
        jsExecuter.executeScript("arguments[0].scrollIntoView(true);",getStarted);


    }

    @Test(enabled = true)
    public void test2() throws InterruptedException {

        //I want to refresh my page
        //driver.navigate().refresh(); --> it will  refresh the website
        driver.get("https://www.techtorialacademy.com/");

        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("history.go(0)");

        // Using JSExecutor We want to scroll the page until end of it
        //window.scrollTo(X,Y)
        Thread.sleep(2000);
        executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        WebElement onlineCourse=driver.findElement(By.xpath("//a[.='Online Course']"));
        Thread.sleep(1000);
   //     executor.executeScript("arguments[0].scrollIntoView(true);",onlineCourse);

        Point point=onlineCourse.getLocation(); // get Location will return Point object
        int xcord=point.getX(); // it will return x coordinate of element on the page
        int ycord=point.getY();  // it will return y coordinate of element on the page
        System.out.println(xcord);
        System.out.println(ycord);

        executor.executeScript("window.scrollTo("+xcord+","+ycord+")");
   //     executor.executeScript("window.scrollBy("+xcord+","+ycord+")");
//        Thread.sleep(2000);
//        executor.executeScript("window.scrollBy(0,1000)");
//        Thread.sleep(2000);
 //       executor.executeScript("window,scrollBy(0,"+ycord+")");  -->> This one is not working

   //     executor.executeScript("arguments[0].setAttribute('style','background:red;border:3px solid black')",onlineCourse);
        executor.executeScript("arguments[0].setAttribute('style','border:3px solid red')",onlineCourse);

        // get html from website using selenium
        // getall cookies
        // delete cookies



    }
}
