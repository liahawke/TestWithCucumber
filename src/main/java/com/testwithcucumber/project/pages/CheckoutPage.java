package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//a[contains(@title, 'Add')]")
    private WebElement incProduct;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']/input[@type='text']")
    private WebElement prodQuantity;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']/input[@type='hidden']")
    private WebElement hiddenQuantity;

    @FindBy(xpath = "//td[@class='cart_unit']/span")
    private WebElement prodPrice;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalPrice;

    @FindBy(xpath = "//td[@id='total_shipping']")
    private WebElement shippingPrice;

    @FindBy(xpath = "//a[contains(@title, 'Delete')]")
    private WebElement deleteBtn;


    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCardMessage;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public CheckoutPage(BaseTest baseTest) {
        super(baseTest);
        baseTest.waitTillElementIsVisible(divPage);
    }

    /** Increase number of products by clicking + button */
    public void clickPlusBtn() {
        baseTest.waitTillElementIsVisible(incProduct);
        incProduct.click();
        baseTest.waitTillTextAppears(prodQuantity, "2");
    }

    /**
     * Get current price
     *
     * @return current price
     */
    public String getTotalPrice(){
        baseTest.waitTillElementIsVisible(totalPrice);
        return totalPrice.getText();
    }

    /** Delete product from the cart */
    public void deleteProduct() {
        baseTest.waitTillElementIsVisible(deleteBtn);
        deleteBtn.click();
    }


    /**
     * Get empty cart message
     *
     * @return Empty cart text
     */
    public String getEmptyCartMessage(){
        baseTest.waitTillElementIsVisible(emptyCardMessage);
        return emptyCardMessage.getText();
    }

}