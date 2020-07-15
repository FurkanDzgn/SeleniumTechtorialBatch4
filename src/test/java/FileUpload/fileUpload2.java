package FileUpload;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class fileUpload2 extends TestBase {

    @Test(priority = 2)
    public void case2() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/upload/");
        Thread.sleep(3000);
        driver.switchTo().frame("flow_close_btn_iframe");
        driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
        driver.switchTo().defaultContent();

    //    driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
        driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\12242\\Downloads\\TechtorialAcademy.png");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();
        String ActualDisplay=driver.findElement(By.xpath("//h3[@id='res']//center")).getText();
        System.out.println(ActualDisplay);
        String extectedDisplay="1 file\n" +
                "has been successfully uploaded.";
        //       Assert.assertEquals(ActualDisplay,extectedDisplay);
        softAssert.assertEquals(ActualDisplay,extectedDisplay);
        softAssert.assertAll();

    }

}
