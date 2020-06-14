package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class CarsCom {

    @Test
    public void newUsedSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        // for drop down box create object from Select class
        // it will take one parameter as element
        // tag of the element must be select for Select class

        WebElement newUSedCars=driver.findElement(By.xpath("//select[@aria-label='Select a stock type']"));
        Select select=new Select(newUSedCars);
        select.selectByVisibleText("Certified Cars");
        Thread.sleep(2000);
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByValue("28880");
        Thread.sleep(1000);
   //     select.deselectAll();
        Thread.sleep(2000);

        //getOptions will return list <Element>
        List<WebElement> options=select.getOptions();

 //       int count=0;
        for (WebElement option:options){
    //        select.selectByIndex(count++);
            System.out.println(option.getText());
    //        Thread.sleep(2000);
        }

        Thread.sleep(3000);
 //       driver.quit();

    }
}
