package com.qa.tests;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KeypadTests extends BaseTest {
    @Test(priority = 1)
    public void CardPay() throws Exception {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement CardPay = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_card_pay");
        CardPay.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement Keypad = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay:id/btn_card_pay");
        CardPay.click();
    }
}
