package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.MainDashPage;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class CalculatorTests extends BaseTest {
MainDashPage mainDashPage;

    @BeforeMethod
    public void beforeMethod(Method m) {

        mainDashPage = new MainDashPage(driver);
    }

    @Test(priority = 1)
    public void CardPay() throws Exception {
        mainDashPage.pressCarPayBtn();
//        MobileElement CardPay = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_card_pay");
//        CardPay.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement KeypadOne = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_one");
        KeypadOne.click();
        MobileElement KeypadTwo = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_two");
        KeypadTwo.click();
        MobileElement KeypadZero = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_zero");
        KeypadZero.click();
        MobileElement KeypadConfirm = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_complete");
        KeypadConfirm.click();

    }
}
