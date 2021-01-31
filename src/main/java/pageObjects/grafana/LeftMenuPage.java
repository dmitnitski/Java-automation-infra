package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {
    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][1]")
    public WebElement btn_create;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][2]")
    public WebElement btn_dashboard;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][3]")
    public WebElement btn_explore;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][4]")
    public WebElement btn_alerting;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][5]")
    public WebElement btn_configuration;

    @FindBy(xpath = "//div[@class='sidemenu-item dropdown'][6]")
    public WebElement btn_server;
}
