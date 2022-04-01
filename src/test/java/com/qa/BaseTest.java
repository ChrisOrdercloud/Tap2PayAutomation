package com.qa;

import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static final int NATIVE_APP = 0;
    protected static final int WEBVIEW = 1;
    protected static AppiumDriver driver;
    protected static Properties props;
    protected static HashMap<String, String> strings = new HashMap<String, String>();
    protected static String dateTime;
    private static AppiumDriverLocalService server;

    InputStream inputStream;
    InputStream stringsis;
    TestUtils utils;

    static Logger log = LogManager.getLogger(BaseTest.class.getName());

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();

        driver = new AndroidDriver<MobileElement>(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }
//    @BeforeSuite
//    public void beforeSuite(){
//        //Starts Appium server programmatically (Run command to clear port if port is already in use/  Isof -P | grep ':4723' | awk '{print @2}' | xargs kill -9)
//        server = getAppiumServerDefault();
//        server.start();
//        server.clearOutPutStreams();
//        //This clears the appium server output in the console, otherwise it's hard to read. When you encounter an issue, switch on to see what's wrong.
//        System.out.println("Appium server started");
//    }

//    @AfterSuite
//    public void  afterSuite(){
//        server.stop();
//        System.out.println("Appium server stopped");
//    }


//        public AppiumDriverLocalService getAppiumServerDefault()  {
//        return  AppiumDriverLocalService.buildDefaultService();
//        }

   // @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeTest

//    public void beforeTest(@Optional String platformName, @Optional String platformVersion, @Optional String deviceName) throws IOException {
//        log.info("This is info massage");
//        log.error("This is a error massage");
//        log.debug("This is a debug massage");
//        log.warn("This is a warning massage");
//
//
//
//        utils = new TestUtils();
//        dateTime = utils.getDateTime();
//        try {
//
//            props = new Properties();
//            String propFilename = "config.properties";
//            inputStream = getClass().getClassLoader().getResourceAsStream(propFilename);
//            String xmlFileName = "strings/strings.xml";
//            props.load(inputStream);
//            stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
//
//            strings = utils.parseStringXML(stringsis);
//
//            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//            desiredCapabilities.setCapability("platformName", platformName);
//            desiredCapabilities.setCapability("deviceName", deviceName);
//            desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
//            desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
//            desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
//
//            desiredCapabilities.setCapability("platformVersion", platformVersion);
//            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//
//
//            //URL appURL = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
//            String appURL = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
//            System.out.println(appURL);
//            desiredCapabilities.setCapability("app", appURL);
//            URL url = new URL(props.getProperty("appiumURL"));
//            driver = new AndroidDriver(url, desiredCapabilities);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
//            if (stringsis != null) {
//                stringsis.close();
//            }
//        }
//
//    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public String getDateTime() {
        return dateTime;
    }

    //This might not be used for T2P
    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    //Managing the waits, manage driver commands
    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
