package com.qa.pages;

import com.qa.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculatorPage extends BasePage {
    public CalculatorPage(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(id = "com.ordercloud.tap_to_pay/.ui.activities.CalculatorActivity")
    private MobileElement calculatorPage;
}