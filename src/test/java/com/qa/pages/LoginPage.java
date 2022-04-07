package com.qa.pages;

import com.qa.pages.base.BasePage;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]")
    private MobileElement WalkthroughBtn;


    @AndroidFindBy (id = "com.ordercloud.tap_to_pay:id/btn_finish")
    private MobileElement Startbtn;


    public LoginPage pressWalkthroughBtn() {
        click(WalkthroughBtn);
        return this;
    }

    public PermissionsPage pressStartBtn() {
        click(Startbtn);
        return new PermissionsPage(driver);
    }
    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();


    }
    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }
}
