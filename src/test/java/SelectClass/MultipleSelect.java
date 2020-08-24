package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultipleSelect {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://mdbootstrap.com/docs/jquery/forms/multiselect/");

        WebElement dropDown=driver.findElement(By.xpath("//select[@class='custom-select browser-default']"));

        Select select=new Select(dropDown);

        select.selectByValue("3");
        Thread.sleep(1000);
        select.selectByIndex(1);
        Thread.sleep(1000);
        select.selectByVisibleText("Two");

        Thread.sleep(1000);
        select.deselectByIndex(1);
        Thread.sleep(1000);
        select.selectByValue("3");
        Thread.sleep(1000);
        select.selectByVisibleText("Two");

        select.deselectAll();


    }
}