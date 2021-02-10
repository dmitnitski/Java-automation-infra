package sanity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class mobileTest {
    private String reportDirectory = "C:/temp/";
    private String reportFormat = "xml";
    private String testName = "OtherMobileMethods.html";
    protected static AndroidDriver<AndroidElement> driver;
    DesiredCapabilities dc;
    protected static TouchAction action;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability(MobileCapabilityType.UDID, "2b744bc0c51c7ece");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4724/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
        action = new TouchAction(driver);
    }

    @AfterClass
    public static void tearDown(){
        if(driver != null)
            driver.quit();
    }

    @Test(priority = 0)
    public static void swipeWhileNotFound_01() {
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        driver.executeScript("seetest:client.swipeWhileNotFound(\"DOWN\", 200, 2000, 'NATIVE', \"xpath=//*[@text='WebView']\", 0, 1000, 5, true)");
        driver.pressKeyCode(4);
    }

    @Test(priority = 1)
    public static void verifyElementFound_02() {
        driver.executeScript("seetest:client.verifyElementFound(\"NATIVE\", \"xpath=//*[@text='TextClock']\",0)");
    }

    @Test(priority = 2)
    public static void startActivity_03(){
        driver.startActivity("com.experitest.ExperiBank", ".LoginActivity");
        driver.pressKeyCode(4);

    }
}
