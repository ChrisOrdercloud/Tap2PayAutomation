package com.qa.pages;

import com.qa.BaseTest;
import com.qa.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WalkthroughPage extends BasePage {

   @AndroidFindBy MobileElement WalkthroughScreen = (MobileElement) driver.findElementById("com.ordercloud.tap_to_pay.ui.activities.TutorialActivity");

   protected WalkthroughPage(AppiumDriver driver) {
      super(driver);
   }
}
