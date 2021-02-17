package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerAdminMenuPage {

    @FindBy(css = "a[href='/admin/users']")
    private WebElement link_users;

    @FindBy(css = "a[href='/admin/settings']")
    private WebElement link_setting;

    @FindBy(css = "a[href='/admin/orgs']")
    private WebElement link_orgs;

    @FindBy(css = "a[href='/admin/stats']")
    private WebElement link_stats;

    public WebElement getLink_users() {
        return link_users;
    }

    public WebElement getLink_setting() {
        return link_setting;
    }

    public WebElement getLink_orgs() {
        return link_orgs;
    }

    public WebElement getLink_stats() {
        return link_stats;
    }
}
