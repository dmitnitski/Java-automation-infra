package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUserPage {
    @FindBy(css = "input[ng-model='user.name']")
    public WebElement userName;

    @FindBy(css = "input[ng-model='user.email']")
    public WebElement userMail;

    @FindBy(css = "input[ng-model='user.login']")
    public WebElement userLogin;

    @FindBy(css = "input[ng-model='user.password']")
    public WebElement userPassword;


    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement submit;


}
