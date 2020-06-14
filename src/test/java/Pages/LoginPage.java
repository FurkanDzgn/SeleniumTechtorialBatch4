package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        // PageFactory with initelements method
        // it will help us initialize our web elements
        PageFactory.initElements(driver,this);
    }

    // @FindBy annotation
    // id, name, className, tagName, xpath, cssSelector, linkText, Partial Link text

    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//input[@id='loginsubmit']")
    public WebElement loginButton;


    // if you have general reusable methods for automation, you need to store them in Utils/BrowserUtils
    // If it is only related with one functionality, or one page you can create under page class.

    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

}
