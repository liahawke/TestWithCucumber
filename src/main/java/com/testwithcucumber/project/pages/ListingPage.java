package com.testwithcucumber.project.pages;

import com.testwithcucumber.project.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListingPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='cat-name']")
    private WebElement headingOfListingPage;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public ListingPage(BaseTest baseTest) {
        super(baseTest);
        baseTest.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on product
     *
     * @param productName
     * @return Product Page
     */
    public ProductPage clickOnProduct(String productName) {
        baseTest.waitTillElementIsVisible(headingOfListingPage);
        baseTest
                .getDriver()
                .findElement(By.xpath("//a[contains(text(),'" + productName + "')]"))
                .click();
        return new ProductPage(baseTest);
    }
}
