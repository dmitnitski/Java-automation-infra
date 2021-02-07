package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;


import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update Text")
    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Insert Key ")
    public static void insertKey(WebElement elem, Keys value) {
        elem.sendKeys(value);
    }

    @Step("Delayed Update Text")
    public static void delayedUpdateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char c:text.toLowerCase().toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(c+"");
        }
    }

    @Step("Update Drop Down")
    public static void updateDropDown(WebElement elem, String text) {
        Select dropDown = new Select(elem);
        wait.until(ExpectedConditions.visibilityOf(elem));
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover")
    public static void mouseHover(WebElement elem) {
        actions.moveToElement(elem).click().build().perform();
    }

}
