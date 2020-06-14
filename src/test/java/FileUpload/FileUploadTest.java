package FileUpload;

import Tests.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    // when I extend this class with TestBase, I need to provide the parameter
    // If I need to provide the parameter, I should use the xml file to run my class

//    public WebDriver driver;
//    @BeforeClass
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//    }
    @Test(priority = 1)
    public void test1(){

        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        // for file upload in Selenium, we need to send the key as a path of the file
        // which we want to upload.
        // to upload the file tag of element should be "input" and type should be "file"
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\12242\\Desktop\\FileUploadTest.png");// -->> Location + FileName
        //Mac User One slash -->
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement textMessage=driver.findElement(By.id("uploaded-files"));
        String actualText=textMessage.getText();
        String expectedTest="FileUploadTest.png";

        softAssert.assertEquals(actualText,expectedTest);
        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void case2() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/upload/");
        Thread.sleep(3000);
     //   driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
        driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\12242\\Downloads\\TechtorialAcademy.png");
        driver.findElement(By.id("submitbutton")).click();
        String ActualDisplay=driver.findElement(By.xpath("//h3[@id='res']//center")).getText();
        String extectedDisplay="1 file\n" +
                "has been successfully uploaded.";
 //       Assert.assertEquals(ActualDisplay,extectedDisplay);
        softAssert.assertEquals(ActualDisplay,extectedDisplay);
        softAssert.assertAll();

    }
}
