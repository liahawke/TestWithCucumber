package com.testwithcucumber.project.test;

import com.testwithcucumber.project.base.BaseTest;
import com.testwithcucumber.project.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OpenSiteAddProductAndCheckTitle extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private ListingPage listingPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    private String productName = "Faded Short Sleeve T-shirts";

    private String actualUserName;

    @Given("The user opens site sees Home Page")
    public void theUserOpensSiteSeesHomePage() {
        homePage = openSite();
    }

    @When("He clicks Login link sees Login page")
    public void heClicksLoginLinkSeesLoginPage() {
        loginPage = homePage.clickLoginLink();
    }

    @When("He fill login form, click login button and get Account page")
    public void heFillsLoginFormPressButtonAndGetAccountPage() { accountPage = loginPage.fillInputOnLoginPage(); }

    @When("He verifies username on Account Page")
    public void heVerifiesUsernameOnAccountPage() {
        accountPage.verifyName();
    }

    @When("He clicks on T-shirts link, gets Listing Page")
    public void heClicksOnMenuLinkAndGetsListingPage() { listingPage = accountPage.clickOnMenuLink(); }

    @When("He clicks on product link, gets Product Page")
    public void heClicksOnProductLinkAndGetsProductPage() { productPage = listingPage.clickOnProduct(productName); }

    @When("He checks breadcrumbs")
    public void heChecksBreabcrumbs() { productPage.checkBreadcrumbs(productPage.parseExpectedBreadcrumbs()); }

    @When("He click add button and adds products to cart")
    public void heClickAddBtnAddProductToCart() { productPage.clickAddBtn(); }

    @When("He click proceed to checkout button and gets Checkout page")
    public void heClickCheckoutBtnAndGetsCheckoutPage() { checkoutPage = productPage.clickCheckoutBtn(); }

    @When("He increase quantity of product")
    public void heIncreaseQuantityOfProduct() { checkoutPage.clickPlusBtn(); }

    @When("He checks product price")
    public void heChecksProductPrice() { checkoutPage.checkPrice(); }

    @When("He deletes product from the cart")
    public void heDeletesProductFromCart() { checkoutPage.deleteProduct(); }

    @When("He checks title on empty cart page")
    public void heChecksTitleOnEmptyCartPage() { checkoutPage.checkTitle(); }

    @Then("User closes browser")
    public void userClosesBrowser() {
        closeSite();
    }
}
