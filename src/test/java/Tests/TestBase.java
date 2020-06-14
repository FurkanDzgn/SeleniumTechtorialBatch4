package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Driver;

public class TestBase {

    public WebDriver driver=null;
    public SoftAssert softAssert;

    @Parameters("driverName")
    @BeforeClass(alwaysRun = true)
    public void setUp(String drivername){
//        WebDriverManager.chromedriver().setup();
//        driver =new ChromeDriver();

        softAssert=new SoftAssert();
        driver= Driver.getDriver(drivername);
        driver.manage().window().maximize();
    }

}
