package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement breadCrums;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    private WebElement addToCardBtn;

    @FindBy(xpath = "//*[@id='layer_cart']")
    private WebElement checkOutPopUp;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public ProductPage(BaseTest baseTest) {
        super(baseTest);
        baseTest.waitTillElementIsVisible(divPage);
    }

    /**
     * Parse Expected Breadcrumbs
     *
     * @return String with expected Breadcrumbs
     */
    public String parseExpectedBreadcrumbs() {
        String expectedBreadCrumbs =
                "> Women>"
                        + clothes.TSHIRTS.getCategoryName()
                        + ">"
                        + clothes.TSHIRTS.getSubcategoryName()
                        + ">"
                        + productName.getText();
        return expectedBreadCrumbs;
    }

    /**
     * Check is breadcrumbs is correct
     *
     * @param expectedBreadCrumbs
     */
    public void checkBreadcrumbs(String expectedBreadCrumbs) {
        baseTest.waitTillElementIsVisible(breadCrums);
        Assert.assertEquals("Breadcrum is different!", expectedBreadCrumbs, breadCrums.getText());
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
}