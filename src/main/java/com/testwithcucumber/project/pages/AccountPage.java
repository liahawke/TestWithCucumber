package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    // Web Elements
    @FindBy(xpath = "//a[@class='account']//span")
    private WebElement userName;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public AccountPage(BaseTest baseTest) {
        super(baseTest);
    }

    /**
     * Get current user name
     *
     * @return current user name
     */
    public String getCurrentUsername(){
        baseTest.waitTillElementIsVisible(userName);
        return userName.getText();
    }

}

