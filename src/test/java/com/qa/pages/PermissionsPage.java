package com.qa.pages;

import com.qa.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PermissionsPage extends BasePage {
    @AndroidFindBy (id = "com.ordercloud.tap_to_pay.ui.activities.PermissionActivity")
        private MobileElement permissionsScreen;


    protected PermissionsPage(AppiumDriver driver) {
        super(driver);
    }
}
