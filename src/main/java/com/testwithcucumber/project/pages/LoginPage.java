package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import com.testwithcucumber.project.utils.YamlParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    // Web elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    private WebElement loginBtn;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public LoginPage(BaseTest baseTest) {
        super(baseTest);
        baseTest.waitTillElementIsVisible(divPage);
    }

    /** Login form */
    public AccountPage fillInputOnLoginPage() {
        loginInput.sendKeys(YamlParser.getYamlData().getEmail());
        passwordInput.sendKeys(YamlParser.getYamlData().getPassword());
        loginBtn.click();
        return new AccountPage(baseTest);
    }

}
