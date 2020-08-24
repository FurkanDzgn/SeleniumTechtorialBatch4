package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentsPage {

    public DepartmentsPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Departments']")
    public WebElement departmentButton;

    @FindBy(xpath = "//input[@title='Add']")
    public WebElement addButton;

    @FindBy(name = "deptname")
    public WebElement departmentName;

    @FindBy(id="deptcode")
    public WebElement departmentCode;

    @FindBy(id="s2id_timezone")
    public WebElement timezone;

    @FindBy(xpath="//span[contains(.,'America/Detroit [EDT]')]")
    public WebElement detroitTime;

    @FindBy(id="submitbutton")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='style-1-icon success']")
    public WebElement successMessage;


}
