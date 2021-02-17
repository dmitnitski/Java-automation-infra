package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUserPage {
    @FindBy(css = "input[ng-model='user.name']")
    private WebElement userName;

    @FindBy(css = "input[ng-model='user.email']")
    private WebElement userMail;

    @FindBy(css = "input[ng-model='user.login']")
    private WebElement userLogin;

    @FindBy(css = "input[ng-model='user.password']")
    private WebElement userPassword;

    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement submit;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getUserMail() {
        return userMail;
    }

    public WebElement getUserLogin() {
        return userLogin;
    }

    public WebElement getUserPassword() {
        return userPassword;
    }

    public WebElement getSubmit() {
        return submit;
    }
}
