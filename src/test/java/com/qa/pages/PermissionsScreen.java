package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PermissionsScreen extends BaseTest {
    @AndroidFindBy (id = "com.ordercloud.tap_to_pay.ui.activities.PermissionActivity")
        private MobileElement permissionsScreen;


}
