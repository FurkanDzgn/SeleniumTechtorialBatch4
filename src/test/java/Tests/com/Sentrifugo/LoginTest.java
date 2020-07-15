package Tests.com.Sentrifugo;

import Pages.LoginPage;
import Tests.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    // we want to make sure before the Test Annotation My object from LoginPage is instantiated
    LoginPage page;
    @BeforeClass
    public void pageSetUp(){
        // WebDriver
        page=new LoginPage(driver);
    }

    // All test annotations will be implemented in this class

    //When you provide more than one parameter, you need to give them inside curly braces { }
    @Parameters({"username","password"})
    @Test
    public void loginTest1(String userName, String passWord){
        // Provide two parameter for username and password.
        // The values will come from the xml runner class.
        // Uptade smokeRunner class to run sentrifigo login test.

        driver.get("http://demo.sentrifugo.com/index.php/");
     //   page.username.sendKeys("EM01");
        page.username.sendKeys(userName);
     //   page.password.sendKeys("sentrifugo");
        page.password.sendKeys(passWord);
        page.loginButton.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl,expectedUrl);

    }
}
