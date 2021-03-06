package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {
    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][1]")
    private WebElement btn_create;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][2]")
    private WebElement btn_dashboard;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][3]")
    private WebElement btn_explore;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][4]")
    private WebElement btn_alerting;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][5]")
    private WebElement btn_configuration;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][6]")
    private WebElement btn_server;

    public WebElement getBtn_create() {
        return btn_create;
    }

    public WebElement getBtn_dashboard() {
        return btn_dashboard;
    }

    public WebElement getBtn_explore() {
        return btn_explore;
    }

    public WebElement getBtn_alerting() {
        return btn_alerting;
    }

    public WebElement getBtn_configuration() {
        return btn_configuration;
    }

    public WebElement getBtn_server() {
        return btn_server;
    }
}
