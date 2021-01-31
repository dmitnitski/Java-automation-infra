package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoElectron extends CommonOps{
    @Test(description = "Test01 create Task")
    @Description("this test create new task")
    public void test01_addNewTask() {
        ElectronFlows.addNewTask("Task_01");
        Verifications.verifyNumber(ElectronFlows.countTasks(), 1);
    }

    @Test(description = "Test02 create new Tasks")
    @Description("this test create 3 new task")
    public void test02_addNewTasks() {
        ElectronFlows.addNewTask("Task_01");
        ElectronFlows.addNewTask("Task_02");
        ElectronFlows.addNewTask("Task_03");
        Verifications.verifyNumber(ElectronFlows.countTasks(), 3);
    }

}
