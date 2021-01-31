package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "user")
    public WebElement userName;

    @FindBy(id = "inputPassword")
    public WebElement pasw;

    @FindBy(xpath = "//button[@aria-label='Login button']")
    public WebElement btn_submit;

    @FindBy(css = "a[class='btn btn-link']")
    public WebElement btn_skip;
}
