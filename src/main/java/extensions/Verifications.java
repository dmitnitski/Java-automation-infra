package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Verifications extends CommonOps{
    @Step("verifyTextInElement")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step("verify numberOfElements")
    public static void numberOfElements(List<WebElement> elements, int expected){
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        assertEquals(elements.size(), expected);
    }

    @Step("visibility Of Elements")
    public static void visibilityOfElements(List<WebElement> elements) {
        if (elements.size() > 0) {
            for (WebElement elem:elements) {
                softAssert.assertTrue(elem.isDisplayed(), "Elem " + elem.getText() + " not displayed");
            }
        }
    }

    @Step("Verify Element Displayed")
    public static void verifyElementExist(List<WebElement> elements, int size) {
        assertTrue(elements.size() ==  size);
    }

    @Step("Verify Text")
    public static void verifyText(String act, String exp) {
        assertEquals(act, exp);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int act, int exp) {
        assertEquals(act, exp);
    }
}
