package com.qa.tests;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CalculatorTests extends BaseTest {

    @Test(priority = 1)
    public void CardPay() throws Exception {

        MobileElement CardPay = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_card_pay");
        CardPay.click();
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
