package com.qa.pages;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMHomePage extends BasePage{

    By profileImage = By.cssSelector("img[class='oxd-userdropdown-img']");

    By logout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickProfileImage(){
        click(profileImage, WaitStrategy.PRESENCE,"Profile picture");
        return this;

    }

    public OrangeHRMLoginPage clickLogout(){
        click(logout, WaitStrategy.CLICKABLE, "logout button");
        return new OrangeHRMLoginPage();
    }


    public String getTitle() {
        return getPageTitle();
    }
}
