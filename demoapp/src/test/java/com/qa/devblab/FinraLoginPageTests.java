package com.qa.devblab;

import com.qa.pages.FinraLoginPage;
import com.qa.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import java.util.Map;

public class FinraLoginPageTests extends BaseTest{

    @Test
    public static void loginFinraTest(Map<String, String> data){

        String title = new FinraLoginPage().enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .enterAnswerToSecurityQuestion(data.get("ans"))
                .clickSubmit()
                .getTitle();


    }
}
