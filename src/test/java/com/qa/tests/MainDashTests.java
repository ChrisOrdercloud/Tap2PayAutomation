package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.MainDashPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MainDashTests extends BaseTest {
    MainDashPage mainDashPage;

    @BeforeMethod
    public void beforeMethod(Method m) {

        mainDashPage = new MainDashPage(driver);
    }

    @Test(priority = 1)
    public void Cardpay() throws Exception {
   Cardpay();
    }
}

