package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodoMain {
    @FindBy(css = "input[placeholder='Create a task']")
    public WebElement create;

    @FindBy(className = "taskWrapper_2u8dN")
    public List<WebElement> list_tasks;

    @FindBy(className = "destroy_19w1q")
    public WebElement btn_x;

}
