package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {

    @Test(description = "Test01 Login to grafana with DB credentials")
    @Description("Login to grafana with DB credentials and verify main header")
    public void test01_verifyHaeder() {
        WebFlows.loginUsingDB();
        Verifications.verifyTextInElement(grafanaMain.head_Dash, "Home Dashboard");
        WebFlows.openServerAdmin();
    }
}