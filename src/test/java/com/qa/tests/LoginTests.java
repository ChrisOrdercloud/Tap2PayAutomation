package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(Method m) {

        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void Walkthrough() throws Exception {
        loginPage.pressWalkthroughBtn();
    }

    @Test(priority = 2)
    public void PermissionsAccept() {

        loginPage.pressStartBtn();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement ContinueBtn = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_request_permission");
        ContinueBtn.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement AcceptPermission = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        AcceptPermission.click();
    }
}






