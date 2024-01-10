package com.qa.pages;

import com.qa.enums.WaitStrategy;
import com.qa.utils.DecodeUtils;
import org.openqa.selenium.By;

public class FinraLoginPage extends BasePage{

    private  By Username = By.name("username");
    private  By Password = By.name("password");
    private  By LoginButton = By.xpath("//button[@type='submit']");
    private By SecurityQuestion = By.name("securityQuestionAnswer");
    private By submitButton =By.id("submit-button");

    public  FinraLoginPage enterUsername(String username){
        sendKeys(Username, username, WaitStrategy.PRESENCE, "password");
        return this;

    }

    public  FinraLoginPage enterPassword(String password){
        sendKeys(Password, DecodeUtils.getBase64DecodedString(password), WaitStrategy.PRESENCE, "password");
        return this;

    }

    public FinraLoginPage enterAnswerToSecurityQuestion(String ans){
        sendKeys(SecurityQuestion, ans, WaitStrategy.PRESENCE, "Profile Image");
        return  this;
    }

    public FinraLoginPage clickSubmit() {
        click(submitButton, WaitStrategy.CLICKABLE, "login button");
        return new FinraHomePage();
    }

    public FinraLoginPage clickLogin() {
        click(LoginButton, WaitStrategy.PRESENCE, "login button");
        return this;
    }

    public String getTitle(){
        return getPageTitle();
    }
}
