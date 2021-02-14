package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.calculator.CalcMainPage;
import pageObjects.grafana.*;
import pageObjects.mortgage.*;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected  static String platform;


    //Web
    protected static WebDriver driver;

    //DataBAse
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;
    //RestPAI
    protected static RequestSpecification request;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Page Objects
    protected static LoginPage grafanaLogin;
    protected static MainPage grafanaMain;
    protected static LeftMenuPage grafanaLeftMenu;
    protected static ServerAdminMenuPage grafanaServerAdminMenu;
    protected static ServerAdminMainPage grafanaServerAdminMain;
    protected static AddNewUserPage grafanaAddNewUser;
    protected static EditUserPage grafanaEditUserPage;

    //Desktop
    protected static CalcMainPage calcMain;

    //Mobile
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static AppiumDriver mobileDriver;
    protected static MortgageMain mortgageMain;

    //Page Objects electron
    protected static pageObjects.todo.TodoMain todoMain;
}