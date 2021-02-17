package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage {
    @FindBy(css = "button[ng-click='deleteUser(user)']")
    private WebElement btn_delete;

    @FindBy(css = "button[ng-show='onConfirm']")
    private WebElement btn_confirmDeleteUser;

    public WebElement getBtn_delete() {
        return btn_delete;
    }

    public WebElement getBtn_confirmDeleteUser() {
        return btn_confirmDeleteUser;
    }
}
