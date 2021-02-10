package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflow.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{
    /**************************************************************
     * Method Name: getData
     * Description: Get data from configuration file
     * Method params: string - param from file
     * Method return: string
     **************************************************************/
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /**************************************************************
     * Method Name: init browser
     * Description: init webdriver with specific browser type
     * Method params: string - browser type
     **************************************************************/
    public void initBrowser(String browserType){
        if(browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        }
        else if(browserType.equalsIgnoreCase("edge")) {
           driver = initEdgeDriver();
        }
        else if(browserType.equalsIgnoreCase("firefox")) {
           driver = initFFDriver();
        }
        else{
               throw new RuntimeException("Invalid platform type");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initGrafana();
    }

    /**************************************************************
     * Method Name: init api
     * Description: init api objects
     **************************************************************/
    public static void initAPI(){
        RestAssured.baseURI = getData("APIurl");
        request = RestAssured.given().auth().preemptive().basic(getData("username"), getData("password")).when();

    }

    /**************************************************************
     * Method Name: init Electron
     * Description: init electron driver for electron apps
     * manipulations
     **************************************************************/
    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));

    }

    /**************************************************************
     * Method Name: init desktop
     * Description: init windows driver for desktop manipulations
     **************************************************************/
    public static void initDesktop(){
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("WinAppDriverServer")), dc);
        }
        catch (Exception e){
            System.out.println("Fail to init desktop web driver");
        }
        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));

    }

    /**************************************************************
     * Method Name: init mobile
     * Description: init mobile driver for mobile manipulations
     **************************************************************/
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UUID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        }catch (Exception e){
            System.out.println("Initialization of Appium Driver fail with error: " + e);
        }
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getData("Timeout")));

    }

    /**************************************************************
     * Method Name: initChromeDriver
     * Description: init chrome driver
     * Return: webdriver
     **************************************************************/
    public static WebDriver initChromeDriver(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       return driver;
    }


    /**************************************************************
     * Method Name: initEdgeDriver
     * Description: init edge driver
     * Return: webdriver
     **************************************************************/
    public static WebDriver initEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    /**************************************************************
     * Method Name: initFFDriver
     * Description: init ff driver
     * Return: webdriver
     **************************************************************/
    public static WebDriver initFFDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }


    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        platform = PlatformName;
        if(platform.equalsIgnoreCase("web")){
            initBrowser(getData("BrowserName"));
        }
        else if(platform.equalsIgnoreCase("api")){
            initAPI();
        }
        else if(platform.equalsIgnoreCase("electron")){
            initElectron();
        }
        else if(platform.equalsIgnoreCase("desktop")){
            initDesktop();
        }
        else if(platform.equalsIgnoreCase("mobile")){
           initMobile();
        }
        else{
            throw new RuntimeException("Invalid platform type");
        }

        softAssert = new SoftAssert();

        if(!platform.equalsIgnoreCase("desktop") & !platform.equalsIgnoreCase("api")){
            actions = new Actions(driver);
        }
        ManageDB.openConnection(getData("DBUrl"), getData("DBusername"), getData("DBpasword"));
    }

    @AfterClass
    public void tearDown(){
        if(!platform.equalsIgnoreCase("api")) {
            if (driver != null) {
                driver.quit();
            }
        }
//        ManageDB.closeConnection();
    }

    @AfterMethod
    public static void  afterMethod(){
        if(platform.equalsIgnoreCase("web")) {
            driver.get(getData("url"));
        }else if(platform.equalsIgnoreCase("electron")){
            ElectronFlows.emptyTasksList();
        }
    }

    @BeforeMethod
    public static void beforeMethod(Method method){
        if(platform.equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.startRecord(method.getName());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
