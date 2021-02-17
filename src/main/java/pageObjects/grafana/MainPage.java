package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//div[@class='text-center dashboard-header']/span")
    private WebElement head_Dash;

    @FindBy(xpath = "//div[@class='progress-step active']")
    private List<WebElement> list_progressSteps;

    public WebElement getHead_Dash() {
        return head_Dash;
    }

    public List<WebElement> getList_progressSteps() {
        return list_progressSteps;
    }
}
