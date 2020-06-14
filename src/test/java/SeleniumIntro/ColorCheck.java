package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ColorCheck {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");

        WebElement pink=driver.findElement(By.id("color_24"));

        // getCssValue(String nameOf Css) --> this method will give css value for the webelement
        System.out.println(pink.getCssValue("background"));
        String colorCode=pink.getCssValue("background");
        // UX designer provide you the exact color which you need to use on website
        // pink --> rgb code for color or hex code of the color
        String height=pink.getCssValue("height");
        String width=pink.getCssValue("width");
        System.out.println(height+"\n"+width);
        System.out.println(pink.getCssValue("color"));
        Assert.assertEquals(height,"22px");
        Assert.assertEquals(width,"22px");
        Assert.assertTrue(colorCode.contains("rgb(252, 202, 205)"));

    }
}
