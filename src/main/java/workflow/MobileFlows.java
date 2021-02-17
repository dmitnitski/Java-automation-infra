package workflow;

import extensions.MobileActions;
import io.qameta.allure.Step;

import utilities.CommonOps;


public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill Form and valculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate){
        MobileActions.updateText(mortgageMain.getTxt_amount(), amount);
        MobileActions.updateText(mortgageMain.getTxt_term(), term);
        MobileActions.updateText(mortgageMain.getTxt_rate(), rate);
        mobileDriver.tap(1, mortgageMain.getTxt_calculate(), 500);
    }

}
