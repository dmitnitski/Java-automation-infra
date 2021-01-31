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
        UIActions.updateText(grafanaLogin.userName, user);
        UIActions.updateText(grafanaLogin.pasw, pasw);
        UIActions.click(grafanaLogin.btn_submit);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Login to grafana while getting cred from DB")
    public static void loginUsingDB(){
        String query = "Select name,password FROM Employees WHERE id ='4'";
        List<String> cred = new ArrayList<String>();
        cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.userName, cred.get(0));
        UIActions.updateText(grafanaLogin.pasw, cred.get(1));
        UIActions.click(grafanaLogin.btn_submit);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow:Open server admin")
    public static void openServerAdmin(){
        UIActions.mouseHover(grafanaLeftMenu.btn_server);
        UIActions.mouseHover(grafanaServerAdminMenu.link_users);
        UIActions.click(grafanaServerAdminMenu.link_users);
    }

    @Step("Business Flow:Create user")
    public static void createNewUser(String name, String email, String login, String pasw){
        UIActions.click(grafanaServerAdminMain.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.userName,name);
        UIActions.updateText(grafanaAddNewUser.userMail,email);
        UIActions.updateText(grafanaAddNewUser.userLogin,login);
        UIActions.updateText(grafanaAddNewUser.userPassword,pasw);
        UIActions.click(grafanaAddNewUser.submit);
    }

    @Step("Business Flow:Delete user")
    public static void deleteUser(String login){
        List<WebElement> users = grafanaServerAdminMain.users;
        for (WebElement user:users){
            if (user.getText().equalsIgnoreCase(login)) {
                UIActions.click(user);
                UIActions.click(grafanaEditUserPage.btn_delete);
                UIActions.click(grafanaEditUserPage.btn_confirmDeleteUser);
            }
        }
    }

    @Step("Business Flow:Search and verify user")
    public static void searchAndVerifyUser(String userName, String isExist){
        UIActions.delayedUpdateText(grafanaServerAdminMain.txt_search, userName);
        if(isExist.equalsIgnoreCase("true")){
            Verifications.verifyElementExist(grafanaServerAdminMain.rows, 1);
        }
        else{
            Verifications.verifyElementExist(grafanaServerAdminMain.rows, 0);
        }
    }
}
