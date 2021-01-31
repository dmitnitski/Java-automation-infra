package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.calculator.CalcMainPage;
import pageObjects.grafana.*;
import pageObjects.todo.TodoMain;

public class ManagePages extends Base{
    public static void initGrafana(){
        grafanaLogin = PageFactory.initElements(driver, LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, LeftMenuPage.class);
        grafanaServerAdminMenu = PageFactory.initElements(driver, ServerAdminMenuPage.class);
        grafanaServerAdminMain = PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, AddNewUserPage.class);
        grafanaEditUserPage = PageFactory.initElements(driver, EditUserPage.class);
    }

    public static void initTodo(){
        todoMain = PageFactory.initElements(driver, TodoMain.class);
    }

    public static  void initCalculator(){
        calcMain = PageFactory.initElements(driver, CalcMainPage.class);
    }
}
