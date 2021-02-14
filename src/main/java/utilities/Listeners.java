package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


public class Listeners extends CommonOps implements ITestListener {
    public void onFinish(ITestContext test) {System.out.println("---- Test : " + test.getName() + " On Finished -----");}

    public void onStart(ITestContext test) {System.out.println("---- Test : " + test.getName() + " On Start -----");}

    public void onTestFailedButWithinSuccessPercentage(ITestResult test){
        System.out.println("------ Test : " + test.getName() + " is partly Failed -----");}


    public void onTestSkipped(ITestResult test) {System.out.println("--- Test : " + test.getName() + " Skipped --- ");}

    public void onTestStart(ITestResult test) {System.out.println("---- Test : " + test.getName() + " Started ----");}

    public void onTestSuccess(ITestResult test) {
        System.out.println("--- Test : " + test.getName() + " Finished ---");
        //Stop recording
        if(platform.equalsIgnoreCase("web")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //delete recording
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete()) {
                System.out.println("File deleted success");
            } else {
                System.out.println(" Failed to delete file");
            }
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("--- Test : " + test.getName() + " Failed ----");
        if(platform.equalsIgnoreCase("web")) {
            saveScreenShot();
            //Stop recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Attachment(value = "Page ScreenShot", type = "image/png")
    public byte[] saveScreenShot(){
        if(!getData("PlatformName").equalsIgnoreCase("mobile")){
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
        else{
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
        }



    }
}
