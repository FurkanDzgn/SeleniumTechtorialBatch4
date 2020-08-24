package Tests.com.Sentrifugo;

import Pages.LoginPage;
import Pages.MaritalStatusPage;
import Tests.TestBase;
import Tests.com.Sentrifugo.TestData.MaritalStatusData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class MaritalStatusTest extends TestBase {

    MaritalStatusPage page;
    LoginPage loginPage;

    @BeforeClass
    public void setUpPage(){
        page=new MaritalStatusPage(driver);
        loginPage=new LoginPage(driver);

    }

//    @DataProvider(name = "maritalTest")
//    public Object[][] getData(){
//
//        return new Object[][]{
//                {"SS","SSingle","test1"},
//                {"MM","MMaried","test2"},
//                {"DD","DDivorced","test3"},
//                {"ww","WWidowed","test4"},
//                {"KK","KKiwi","test5"}
//        };
//
//    }


    @Parameters({"username","password"})
    @Test(priority = 1)
    public void validationErrorMessage(String user,String pass){
        driver.get("http://demo.sentrifugo.com/index.php/");
        // this will login the page
  //      loginPage.login("EM01","sentrifugo");
        loginPage.login(user,pass);
        page.genderButton.click();
        page.maritalStatusButton.click();
        page.addButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        page.saveButton.click();
        String actualCode=page.errorMaritalCode.getText();
        String expectedCode="Please enter marital code.";

        String actualStatusError=page.errorMaritalStatusName.getText();
        String expectedStatusError="Please enter marital status.";

        //Soft Assertion
        softAssert.assertEquals(actualCode,expectedCode);
        softAssert.assertEquals(actualStatusError,expectedStatusError);
        softAssert.assertAll(); // -->> assertAll should be at the end of your Test annotation.

        //Hard Assertion
//        Assert.assertEquals(actualCode,expectedCode);
//        Assert.assertEquals(actualStatusError,expectedStatusError);

    }

    @Test(priority = 2,enabled = true, dataProvider = "maritalTest", dataProviderClass = MaritalStatusData.class)
    public void validationMaritalStatusCreation(String code,String status,String description) throws InterruptedException {
//        driver.get("http://demo.sentrifugo.com/index.php/");
//        // this will login the page
//        loginPage.login("EM01","sentrifugo");
//
//        page.genderButton.click();
//        page.maritalStatusButton.click();
//        page.addButton.click();

        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   //     page.maritalCode.sendKeys("SS");
        page.maritalCode.sendKeys(code);
  //      page.maritalStatus.sendKeys("SingleT");
        page.maritalStatus.sendKeys(status);
   //     page.description.sendKeys("Test new creation of Marital status");
        page.description.sendKeys(description);
        page.saveButton.click();
        Thread.sleep(400);
        //Even though my assertion is failing I want to click the addButton
        // Instead of soft assert if I use Hard assert and my assertion is failed.Data provider will continue to run or not?
        softAssert.assertTrue(page.successMessage.isDisplayed());
 //       Assert.assertTrue(page.successMessage.isDisplayed());
        page.addButton.click();

        softAssert.assertAll();

    }


}
