package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import com.testwithcucumber.project.base.ClothesCategories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    // Web Elements
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']")
    public WebElement tshirtsTitle;

    // Instances of BaseTest
    protected BaseTest baseTest;

    // Instance of ClothesCategories
    ClothesCategories clothes;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public AbstractPage(BaseTest baseTest) {
        this.baseTest = baseTest;
        PageFactory.initElements(baseTest.getDriver(), this);
        baseTest.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on Sign in link
     *
     * @return Login Page
     */
    public LoginPage clickLoginLink() {
        baseTest.waitTillElementIsVisible(loginLink);
        loginLink.click();
        return new LoginPage(baseTest);
    }

    /** Click on Dresses link */
    public ListingPage clickOnMenuLink() {
        baseTest.waitTillElementIsVisible(tshirtsTitle);
        tshirtsTitle.click();
        return new ListingPage(baseTest);
    }

}
