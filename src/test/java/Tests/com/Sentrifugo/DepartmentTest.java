package Tests.com.Sentrifugo;

import Pages.DepartmentsPage;
import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepartmentTest extends TestBase {

    DepartmentsPage departmentsPage;
    LoginPage loginPage;

    @BeforeClass
    public void setUpPage(){

        departmentsPage=new DepartmentsPage(driver);
        loginPage=new LoginPage(driver);
    }

      @Test
      public void departmentCreation() throws InterruptedException {
        driver.get("http://demo.sentrifugo.com/index.php/");
        // this will login the page
        loginPage.login("EM01","sentrifugo");

        // click the departments button
          departmentsPage.departmentButton.click();
        departmentsPage.addButton.click();
        // click the add button
 //       departmentsPage.addButton.click();
        departmentsPage.departmentName.sendKeys("Finance");
        departmentsPage.departmentCode.sendKeys("FN");
        departmentsPage.timezone.click();
        departmentsPage.detroitTime.click();
        departmentsPage.saveButton.click();
        Thread.sleep(300);
        Assert.assertTrue(departmentsPage.successMessage.isDisplayed());
//
//        // Every page create page class
//        // Store all webelements inside Page class
//        // Create Test class under Tests package
//        // Inside test class Create an object from page class
//        // Extent test class with TestBase Class
//
//
    }

}
