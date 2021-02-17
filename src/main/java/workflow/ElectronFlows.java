package workflow;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task")
    public static void addNewTask(String task_name){
        UIActions.updateText(todoMain.getCreate(), task_name);
        UIActions.insertKey(todoMain.getCreate(), Keys.RETURN);
    }

    @Step("Count and Return Number of Tasks")
    public static int countTasks(){
        return todoMain.getList_tasks().size();
    }

    @Step("Empty Tasks List")
    public static void emptyTasksList(){
        for(int i=0; i<countTasks(); i++){
            UIActions.mouseHover(todoMain.getBtn_x());
        }
    }
}
