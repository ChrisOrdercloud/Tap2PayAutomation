package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]")
    private MobileElement WalkthroughBtn;


    @AndroidFindBy (id = "com.ordercloud.tap_to_pay:id/btn_finish")
    private MobileElement Startbtn;


    public LoginPage pressWalkthroughBtn() {
        click(WalkthroughBtn);
        return this;
    }

    public PermissionsScreen PressStartBtn() {
        click(Startbtn);
        return new PermissionsScreen();
    }

}
