package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerAdminMenuPage {

    @FindBy(css = "a[href='/admin/users']")
    public WebElement link_users;

    @FindBy(css = "a[href='/admin/settings']")
    public WebElement link_setting;

    @FindBy(css = "a[href='/admin/orgs']")
    public WebElement link_orgs;

    @FindBy(css = "a[href='/admin/stats']")
    public WebElement link_stats;
}
