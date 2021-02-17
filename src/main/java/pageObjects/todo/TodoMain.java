package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodoMain {
    @FindBy(css = "input[placeholder='Create a task']")
    private WebElement create;

    @FindBy(className = "taskWrapper_2u8dN")
    private List<WebElement> list_tasks;

    @FindBy(className = "destroy_19w1q")
    private WebElement btn_x;

    public WebElement getCreate() {
        return create;
    }

    public List<WebElement> getList_tasks() {
        return list_tasks;
    }

    public WebElement getBtn_x() {
        return btn_x;
    }
}
