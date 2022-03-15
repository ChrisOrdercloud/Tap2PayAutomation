package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WalkthroughScreen extends BaseTest {

   @AndroidFindBy MobileElement WalkthroughScreen = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay.ui.activities.TutorialActivity");

}
