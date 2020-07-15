package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectPractice {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/12242/Desktop/After%203%20motnhs%20sublime/Techtorial%20(2).html");
        //Select the mexico
        //After finding the element of Select, then you can sendKey to select Mexico
        WebElement country=driver.findElement(By.name("country"));
        country.sendKeys("MEXICO");
       // driver.switchTo().window();
     //   driver.switchTo().defaultContent();

    }
    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("file:///C:/Users/12242/Desktop/After%203%20motnhs%20sublime/Techtorial%20(2).html");
        WebElement dropDowm=driver.findElement(By.name("country"));
        // Select constructor requires one parameter as webelement of Select tag
        Select select=new Select(dropDowm);
        // selectByIndex will select the option matching with index number
        // index number starts from 0 in dropdown
        select.selectByIndex(2);
        //selectByText --> it will take one parameter as
        // String which is value of country,it will select giving parameter
        Thread.sleep(2000);
        select.selectByVisibleText("BOLIVIA ");
        // selectByValue --> it will select the option according their values.
        // * Selecting with value only possible,if option has value attribute
        Thread.sleep(2000);
        select.selectByValue("239");// --> value of option


//        driver.manage().window().maximize();
//        driver.switchTo().defaultContent();
    }

    @Test
    public void test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/12242/Desktop/After%203%20motnhs%20sublime/Techtorial%20(2).html");

        WebElement dropDowm=driver.findElement(By.name("country"));
        Select select=new Select(dropDowm);

        // getFirstSelectedOption() method will return webElement of default selected option from dropdown
        WebElement defaultOption=select.getFirstSelectedOption();
        String actualResult=defaultOption.getText().trim();
        String expectedResult="UNITED STATES";

        //assertEquals will compare two parameters
        Assert.assertEquals(actualResult,expectedResult);

//        driver.manage().window().maximize();
//        driver.switchTo().defaultContent();

    }

    @Test
    public void test4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/12242/Desktop/After%203%20motnhs%20sublime/Techtorial%20(2).html");

        WebElement dropDowm=driver.findElement(By.name("country"));
        Select select=new Select(dropDowm);

        //getOptions() method will return list of webelement for all option under the select tag
        List<WebElement> options=select.getOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }
        int countryNumber=options.size();
        int expectedCountryNumber=264; // business
   //   System.out.println(countryNumber);

        Assert.assertTrue(countryNumber == expectedCountryNumber);

//        driver.manage().window().maximize();
    }


}
