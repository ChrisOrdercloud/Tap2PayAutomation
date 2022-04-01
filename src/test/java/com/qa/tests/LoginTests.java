package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.WalkthroughScreen;
import io.appium.java_client.MobileElement;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {
    private static final String TAG = LoginTests.class.getSimpleName();
    LoginPage loginPage;
    WalkthroughScreen walkthroughScreen;
    InputStream datais;
    JSONObject loginUsers;

//      @BeforeClass
//    public void beforeclass() throws IOException {
//        try {
//            String dataFileName = "data/loginUsers.json";
//            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
//            JSONTokener tokener = new JSONTokener(datais);
//            loginUsers = new JSONObject(tokener);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            if (datais != null) {
//                datais.close();
//            }
//        }
//
//    }

    @AfterClass
    public void afterClass() {
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test(priority = 1)
    public void Walkthrough() throws Exception {

        loginPage.pressWalkthroughBtn();
        System.out.println("Test walkthrough flow");

    }

    @Test(priority = 2)
    public void PermissionsAccept() {

        loginPage.PressStartBtn();
        System.out.println("Tets Start Button");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement ContinueBtn = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_request_permission");
        System.out.println("Clicking Continue Button to request permission pop-ups");
        ContinueBtn.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement AcceptPermission = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        System.out.println("Clicking allow Button on permissions");
        AcceptPermission.click();



    }
//    @Test(priority = 3)
//    public void CardPay() throws Exception {
//
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        MobileElement CardPay = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_card_pay");
//        CardPay.click();
//        System.out.println("CardPay button and Card screen check");
//
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        MobileElement Keypad = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_card_pay");
//        CardPay.click();
//        System.out.println("CardPay button and Card screen check");
//
//
//    }
}






