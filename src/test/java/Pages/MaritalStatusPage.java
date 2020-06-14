package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaritalStatusPage {

    public MaritalStatusPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Gender']")
    public WebElement genderButton;

    @FindBy(id="87")
    public WebElement maritalStatusButton;

    @FindBy(xpath = "//input[@title='Add']")
    public WebElement addButton;

    @FindBy(id="maritalcode")
    public WebElement maritalCode;

    @FindBy(id="maritalstatusname")
    public WebElement maritalStatus;

    @FindBy(id="description")
    public WebElement description;

    @FindBy(id="submitbutton")
    public WebElement saveButton;

    @FindBy(className = "ml-alert-1-success")
    public WebElement successMessage;

    @FindBy(id="errors-maritalcode")
    public WebElement errorMaritalCode;

    @FindBy(id="errors-maritalstatusname")
    public WebElement errorMaritalStatusName;


}
