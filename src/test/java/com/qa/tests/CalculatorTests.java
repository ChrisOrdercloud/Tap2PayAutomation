package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.MainDashPage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CalculatorTests extends BaseTest {

    @Test(priority = 1)
    public void CardPay() throws Exception {
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        MobileElement CardPay = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button");
//        CardPay.click();
      //  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
