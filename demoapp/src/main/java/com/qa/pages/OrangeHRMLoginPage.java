package com.qa.pages;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.utils.DecodeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage extends BasePage{

    private By Username = By.name("username");

    private By Password = By.name("password");

    private By LoginButton = By.xpath( "//button[@type='submit']");

    WebDriver driver;


    public OrangeHRMLoginPage enterUsername(String username) {
        sendKeys(Username, username, WaitStrategy.PRESENCE, "username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(Password, DecodeUtils.getBase64DecodedString(password), WaitStrategy.PRESENCE, "password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(LoginButton, WaitStrategy.PRESENCE, "login button");
        return new OrangeHRMHomePage();
    }


    public String getTitle() {
        return getPageTitle();
    }
}
