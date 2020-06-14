package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WarmUpOne {
    //    TASK:
//    Go to google search with selenium
//    Validate  all the results related with Selenium.
//    Find the titles and validate titles has Selenium keyword
    // To adjust the structure of your code option(alt)+command +l
    public static void main(String[] args) {

        // WebdriverManager to get the chromedriver
        //  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  NO NEED ANYMORE
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Selenium");
        //div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']
        //div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']
        WebElement searchKey = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']"));
        searchKey.submit();

        List<WebElement> headers = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        for (WebElement head : headers) {
            //     System.out.println(head.getText());
            String hd = head.getText();
            if (!hd.equals("")) {
                if (hd.contains("Selenium") || hd.contains("selenium")) {
                    System.out.println("Include Selenium");
                } else {
                    System.out.println("Doesn't include Selenium");
                }
            }
        }


    }
}

