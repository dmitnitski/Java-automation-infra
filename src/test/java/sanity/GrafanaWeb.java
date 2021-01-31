package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.WebFlows;

import javax.swing.text.Utilities;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test01 verifyHaeder")
    @Description("this test verify login and main header")
    public void test01_verifyHaeder() {
        WebFlows.login("admin", "admin");
        Verifications.verifyTextInElement(grafanaMain.head_Dash, "Home Dashboard");
        WebFlows.openServerAdmin();
    }

    @Test(description = "Test02 verify users")
    @Description("this test verify default users")
    public void test02_verifyUsers() {
        WebFlows.openServerAdmin();
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test03 verify add user")
    @Description("this test verify adding users")
    public void test03_addNewUser() {
        WebFlows.openServerAdmin();
        WebFlows.createNewUser("Dima", "dmitnitzki@aternity.com", "Dimam", "123456");
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 2);
    }

    @Test(description = "Test04 verify delete user")
    @Description("this test verify deleting users")
    public void test04_verifyUserDeleted() {
        WebFlows.openServerAdmin();
        WebFlows.deleteUser("dimam");
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test05 progress steps")
    @Description("this test verify progress steps")
    public void test05_verifyProgressSteps() {
        Verifications.visibilityOfElements(grafanaMain.list_progressSteps);
        WebFlows.openServerAdmin();
        WebFlows.createNewUser("Dima", "a@gmail.com","dima", "12345");
    }

    @Test(description = "Test06 search users", dataProvider = "Users data provider", dataProviderClass = utilities.ManageDDT.class)
    @Description("this test search for users in the table using ddt")
    public void test06_searchUsers(String user, String isExist) {
        System.out.println("The user is " + user + " is Exist " + isExist);
        WebFlows.openServerAdmin();
        WebFlows.searchAndVerifyUser(user, isExist);
        WebFlows.deleteUser("dima");

    }
}