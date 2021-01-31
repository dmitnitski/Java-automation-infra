package workflow;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;
import utilities.ManagePages;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Addition 1 + 4")
    public static void calculateAddition(){
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_1());
        UIActions.click(calcMain.getBtn_plus());
        UIActions.click(calcMain.getBtn_4());
        UIActions.click(calcMain.getBtn_equals());
    }
}
