package sanity;
import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import io.qameta.allure.Description;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.ApiFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaApi extends CommonOps {

    @Test(description = "Test 1: Get Team from Grafana", priority = 1)
    @Description("This test verify Team proparty")
    public void test_01_verifyTeam(){
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "myteam");
    }

    @Test(description = "Test 2: Create Team And Verify", priority = 2)
    @Description("Create Team And Verify")
    public void test_02_createTeamAndVerify() {
        ApiFlows.createNewTeam("ateam", "ateam@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "2");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "ateam");
    }

    @Test(description = "Test 2: Update Team And Verify", priority = 3)
    @Description("Update Team And Verify")
    public void test_03_updateTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.updateTeam("Cteam", "ateam@gmail.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "Cteam");
    }

    @Test(description = "Test 2: Delete Team And Verify", priority = 4)
    @Description("Delete Team And Verify")
    public void test_04_DeleteTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[0].id");
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "2");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}
