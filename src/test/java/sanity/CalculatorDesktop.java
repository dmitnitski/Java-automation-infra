package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.DesktopFlows;
import workflow.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {
    @Test(description = "Test01 Verify Addition Command")
    @Description("Test Calculator Addition action")
    public void test01_calcAddition() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.getBtn_result(), "Display is 7");
    }
}
