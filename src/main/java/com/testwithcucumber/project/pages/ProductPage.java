package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {


    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    private WebElement addToCardBtn;

    @FindBy(xpath = "//*[@id='layer_cart']")
    private WebElement checkOutPopUp;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement breadCrumbs;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public ProductPage(BaseTest baseTest) {
        super(baseTest);
        baseTest.waitTillElementIsVisible(divPage);
    }


    /** Click on Add product button */
    public void clickAddBtn() {
        baseTest.waitTillElementIsVisible(addToCardBtn);
        addToCardBtn.click();
        baseTest.waitTillElementIsVisible(checkOutPopUp);
    }

    /**
     * Proceed to checkout page
     *
     * @return CheckoutPage
     */
    public CheckoutPage clickCheckoutBtn() {
        baseTest.waitTillElementIsVisible(checkoutBtn);
        checkoutBtn.click();
        return new CheckoutPage(baseTest);
    }

    /**
     * Get current breadcrumb
     *
     * @return current breadcrumb
     */
    public String getBreadcrumbs(){
        baseTest.waitTillElementIsVisible(breadCrumbs);
        return breadCrumbs.getText();
    }
}