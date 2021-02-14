package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobileActions extends CommonOps {
    @Step("Tap on element")
    public static void tap(int fingers, MobileElement elem, int duration) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        mobileDriver.tap(fingers, elem, duration);
    }

    @Step("Swipe on element")
    public static void swipe(int stratX, int startY, int endX, int endY, int duration) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.SECONDS);
        mobileDriver.swipe(stratX, startY, endX, endY, duration);
    }

    @Step("Zoom element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        mobileDriver.zoom(elem);
    }

    @Step("Pinch element")
    public static void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        mobileDriver.pinch(elem);
    }

    @Step("Execute script")
    public static void executScript(String script) {
        mobileDriver.executeScript(script);
    }

    @Step("Update Text")
    public static void updateText(MobileElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
}
