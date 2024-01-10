package com.qa.pages;

import com.qa.enums.WaitStrategy;
import com.qa.utils.DecodeUtils;
import org.openqa.selenium.By;

public class FinraHomePage extends FinraLoginPage {

    private By ProfileLogo = By.xpath("//div[@class='user-circle' and role='button']");
    private By SignOutButton = By.id("signOut");

    public FinraHomePage clickProfileImage(){
        click(ProfileLogo, WaitStrategy.PRESENCE, "Profile Image");
        return  this;
    }
    public FinraLoginPage clickLogOut(){
        click(SignOutButton, WaitStrategy.PRESENCE,"LogOut");
        return new FinraLoginPage();
    }

}
