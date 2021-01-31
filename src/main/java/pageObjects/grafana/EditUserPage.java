package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage {
    @FindBy(css = "button[ng-click='deleteUser(user)']")
    public WebElement btn_delete;

    @FindBy(css = "button[ng-show='onConfirm']")
    public WebElement btn_confirmDeleteUser;
}
