package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServerAdminMainPage {
        @FindBy(xpath = "//tr[@ng-repeat='user in ctrl.users']")
        private List<WebElement> rows;

        @FindBy(css = "a[class='btn btn-primary']")
        private WebElement btn_newUser;

        @FindBy(xpath = "//tr[@ng-repeat='user in ctrl.users']/td[2]")
        private List<WebElement> users;

        @FindBy(css = "input[placeholder='Find user by name/login/email']")
        private WebElement txt_search;

        public List<WebElement> getRows() {
                return rows;
        }

        public WebElement getBtn_newUser() {
                return btn_newUser;
        }

        public List<WebElement> getUsers() {
                return users;
        }

        public WebElement getTxt_search() {
                return txt_search;
        }
}

