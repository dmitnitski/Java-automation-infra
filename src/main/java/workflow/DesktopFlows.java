package workflow;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;


public class DesktopFlows extends CommonOps {
    @Step("Business Flow: Calculate Addition")
    public static void calculateAddition(int a, int b) {
        clearCalc();
        typeNumber(a);
        UIActions.click(calcMain.getBtn_plus());
        typeNumber(b);
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Business Flow: Get Calculator Result")
    public static String getResult() {
        return calcMain.getBtn_result().getText().replace("Display is", "").trim();
    }

    private static void clearCalc() {
        if(getResult().equals("0"))
            UIActions.click(calcMain.getBtn_clear());
        else
            UIActions.click(calcMain.getBtn_clearEntry());
    }

    //Type Number on Calculator
    private static void typeNumber(int n) {
        String s = String.valueOf(n);
        for (int i = 0 ; i < s.length() ; i++) {
            UIActions.click(digitToCalcButton(Character.getNumericValue(s.charAt(i))));
        }
    }

    private static WebElement digitToCalcButton(int n) {
        WebElement button;
        switch (n) {
            case 1:
                button = calcMain.getBtn_1();
                break;
            case 2:
                button = calcMain.getBtn_2();
                break;
            case 3:
                button = calcMain.getBtn_3();
                break;
            case 4:
                button = calcMain.getBtn_4();
                break;
            case 5:
                button = calcMain.getBtn_5();
                break;
            case 6:
                button = calcMain.getBtn_6();
                break;
            case 7:
                button = calcMain.getBtn_7();
                break;
            case 8:
                button = calcMain.getBtn_8();
                break;
            case 9:
                button = calcMain.getBtn_9();
                break;
            case 0:
                button = calcMain.getBtn_0();
                break;
            default:
                button = null;
                throw new ArithmeticException("Invalid number, cannot convert to calculator button");
        }
        return button;
    }
}
