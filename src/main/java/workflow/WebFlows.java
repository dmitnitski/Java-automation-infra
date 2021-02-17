package workflow;


import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;


public class WebFlows extends CommonOps {
    @Step("Business Flow:Login")
    public static void login(String user, String pasw){
        UIActions.updateText(grafanaLogin.getUserName(), user);
        UIActions.updateText(grafanaLogin.getPasw(), pasw);
        UIActions.click(grafanaLogin.getBtn_submit());
        UIActions.click(grafanaLogin.getBtn_skip());
    }

    @Step("Login to grafana while getting cred from DB")
    public static void loginUsingDB(){
        String query = "Select name,password FROM Employees WHERE id ='4'";
        List<String> cred = new ArrayList<String>();
        cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.getUserName(), cred.get(0));
        UIActions.updateText(grafanaLogin.getPasw(), cred.get(1));
        UIActions.click(grafanaLogin.getBtn_submit());
        UIActions.click(grafanaLogin.getBtn_skip());
    }

    @Step("Business Flow:Open server admin")
    public static void openServerAdmin(){
        UIActions.mouseHover(grafanaLeftMenu.getBtn_server());
        UIActions.mouseHover(grafanaServerAdminMenu.getLink_users());
        UIActions.click(grafanaServerAdminMenu.getLink_users());
    }

    @Step("Business Flow:Create user")
    public static void createNewUser(String name, String email, String login, String pasw){
        UIActions.click(grafanaServerAdminMain.getBtn_newUser());
        UIActions.updateText(grafanaAddNewUser.getUserName(),name);
        UIActions.updateText(grafanaAddNewUser.getUserMail(),email);
        UIActions.updateText(grafanaAddNewUser.getUserLogin(),login);
        UIActions.updateText(grafanaAddNewUser.getUserPassword(),pasw);
        UIActions.click(grafanaAddNewUser.getSubmit());
    }

    @Step("Business Flow:Delete user")
    public static void deleteUser(String login){
        List<WebElement> users = grafanaServerAdminMain.getUsers();
        for (WebElement user:users){
            if (user.getText().equalsIgnoreCase(login)) {
                UIActions.click(user);
                UIActions.click(grafanaEditUserPage.getBtn_delete());
                UIActions.click(grafanaEditUserPage.getBtn_confirmDeleteUser());
            }
        }
    }

    @Step("Business Flow:Search and verify user")
    public static void searchAndVerifyUser(String userName, String isExist){
        UIActions.delayedUpdateText(grafanaServerAdminMain.getTxt_search(), userName);
        if(isExist.equalsIgnoreCase("true")){
            Verifications.verifyElementExist(grafanaServerAdminMain.getRows(), 1);
        }
        else{
            Verifications.verifyElementExist(grafanaServerAdminMain.getRows(), 0);
        }
    }
}
