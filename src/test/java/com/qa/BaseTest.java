package com.qa;

import com.qa.utils.AwsUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static AppiumDriver driver;

    protected static String dateTime;

    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {
        //* Switch between AWS and local while developing
      //  appiumSetup();
        localSetup();
    }
//* This sets the local variables while developing,
    private void localSetup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "app" + File.separator + "T2Pdebug.apk";
        desiredCapabilities.setCapability(MobileCapabilityType.APP, appUrl);
        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    private void appiumSetup() throws MalformedURLException {
        AwsUtils.setEmulatorTime();
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL(URL_STRING);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }


//*         This might not be used for T2P
////    public void waitForVisibility(MobileElement e) {
////        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
////        wait.until(ExpectedConditions.visibilityOf(e));
////    }
////
////    //Managing the waits, manage driver commands
////    public void click(MobileElement e) {
////        waitForVisibility(e);
////        e.click();
////    }
//
////    public void sendKeys(MobileElement e, String txt) {
////        waitForVisibility(e);
////        e.sendKeys(txt);
////    }
////
////    public String getAttribute(MobileElement e, String attribute) {
////        waitForVisibility(e);
////        return e.getAttribute(attribute);
////    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

}
