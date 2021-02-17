package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "user")
    private WebElement userName;

    @FindBy(id = "inputPassword")
    private WebElement pasw;

    @FindBy(xpath = "//button[@aria-label='Login button']")
    private WebElement btn_submit;

    @FindBy(css = "a[class='btn btn-link']")
    private WebElement btn_skip;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPasw() {
        return pasw;
    }

    public WebElement getBtn_submit() {
        return btn_submit;
    }

    public WebElement getBtn_skip() {
        return btn_skip;
    }
}
