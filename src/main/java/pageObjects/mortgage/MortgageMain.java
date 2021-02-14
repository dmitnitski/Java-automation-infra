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
    public AndroidElement txt_amount;

    @AndroidFindBy(id = "etTerm")
    public AndroidElement txt_term;

    @AndroidFindBy(id = "etRate")
    public AndroidElement txt_rate;

    @AndroidFindBy(id = "btnCalculate")
    public AndroidElement txt_calculate;

    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement txt_repayment;

}
