package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServerAdminMainPage {
        @FindBy(xpath = "//tr[@ng-repeat='user in ctrl.users']")
        public List<WebElement> rows;

        @FindBy(css = "a[class='btn btn-primary']")
        public WebElement btn_newUser;

        @FindBy(xpath = "//tr[@ng-repeat='user in ctrl.users']/td[2]")
        public List<WebElement> users;

        @FindBy(css = "input[placeholder='Find user by name/login/email']")
        public WebElement txt_search;
}

