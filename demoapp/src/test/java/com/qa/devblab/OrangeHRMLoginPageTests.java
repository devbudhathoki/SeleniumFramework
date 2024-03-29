package com.qa.devblab;

import com.qa.pages.OrangeHRMLoginPage;

import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHRMLoginPageTests extends BaseTest{

    @Test
    public void loginLogoutTest(Map<String, String> data){
        String title = new OrangeHRMLoginPage()
                .enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .clickProfileImage()
                .clickLogout()
                .getTitle();

    }
}
