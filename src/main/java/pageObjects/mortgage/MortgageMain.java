package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class MortgageMain {

    private AppiumDriver mobileDriver;

    public MortgageMain(AppiumDriver driver){
        this.mobileDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "etAmount")
    private AndroidElement txt_amount;

    @AndroidFindBy(id = "etTerm")
    private AndroidElement txt_term;

    @AndroidFindBy(id = "etRate")
    private AndroidElement txt_rate;

    @AndroidFindBy(id = "btnCalculate")
    private AndroidElement txt_calculate;

    @AndroidFindBy(id = "tvRepayment")
    private AndroidElement txt_repayment;

    public AppiumDriver getMobileDriver() {
        return mobileDriver;
    }

    public AndroidElement getTxt_amount() {
        return txt_amount;
    }

    public AndroidElement getTxt_term() {
        return txt_term;
    }

    public AndroidElement getTxt_rate() {
        return txt_rate;
    }

    public AndroidElement getTxt_calculate() {
        return txt_calculate;
    }

    public AndroidElement getTxt_repayment() {
        return txt_repayment;
    }
}
