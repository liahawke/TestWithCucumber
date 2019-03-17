package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    // User name
    private final String USERNAME = "Lia Hawke";

    // Web Elements
    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement userName;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public AccountPage(BaseTest baseTest) {
        super(baseTest);
        baseTest.waitTillElementIsVisible(divPage);
    }

    /** Verify username */
    public void verifyName() {
        Assert.assertEquals("User name is wrong", USERNAME, userName.getText());
    }
}

