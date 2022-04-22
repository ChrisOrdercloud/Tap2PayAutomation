package com.qa.pages;

import com.qa.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainDashPage extends BasePage {
    public MainDashPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ordercloud.tap_to_pay:id/btn_card_pay")
    private MobileElement CardPayBtn;

    public CalculatorPage pressCarPayBtn(){
        CardPayBtn.click();
        return new CalculatorPage(driver);
    }


}
