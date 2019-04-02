package com.testwithcucumber.project.test;

import com.testwithcucumber.project.base.BaseTest;
import com.testwithcucumber.project.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenSiteAddProductAndCheckTitle extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private ListingPage listingPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    private String productName = "Faded Short Sleeve T-shirts";

    private String accountName;
    private String  currentBreadcrumbs;
    private String currentPrice;
    private String currentTitle;

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
        accountName = accountPage.getCurrentUsername();
    }

    @Then("Account name is '([^\"]*)'")
    public void usernameIs(String expectedName) {
        Assert.assertEquals("User name is wrong", expectedName, accountName);
    }

    @When("He clicks on T-shirts link, gets Listing Page")
    public void heClicksOnMenuLinkAndGetsListingPage() { listingPage = accountPage.clickOnMenuLink(); }

    @When("He clicks on product link, gets Product Page")
    public void heClicksOnProductLinkAndGetsProductPage() { productPage = listingPage.clickOnProduct(productName); }

    @When("He checks breadcrumbs")
    public void heChecksBreabcrumbs() { currentBreadcrumbs = productPage.getBreadcrumbs(); }

    @Then("Breadcrumb is '([^\"]*)'")
    public void breadcrumbIs(String expectedBreadcrumb) {
        Assert.assertEquals("Breadcrumb is wrong", expectedBreadcrumb, currentBreadcrumbs);
    }

    @When("He click add button and adds products to cart")
    public void heClickAddBtnAddProductToCart() { productPage.clickAddBtn(); }

    @When("He click proceed to checkout button and gets Checkout page")
    public void heClickCheckoutBtnAndGetsCheckoutPage() { checkoutPage = productPage.clickCheckoutBtn(); }

    @When("He increase quantity of product")
    public void heIncreaseQuantityOfProduct() { checkoutPage.clickPlusBtn(); }

    @When("He checks product price")
    public void heChecksProductPrice() { currentPrice = checkoutPage.getTotalPrice(); }

    @Then("Price is '([^\"]*)'")
    public void priceIs(String expectedPrice) {
        Assert.assertEquals("Price is different!", expectedPrice, currentPrice);
    }
    @When("He deletes product from the cart")
    public void heDeletesProductFromCart() { checkoutPage.deleteProduct(); }

    @When("He checks title on empty cart page")
    public void heChecksTitleOnEmptyCartPage() { currentTitle = checkoutPage.getEmptyCartMessage(); }

    @Then("Title is '([^\"]*)'")
    public void titleIs(String expectedTitle) {
        Assert.assertEquals("Card isn't empty!", expectedTitle, currentTitle);
    }

    @Then("User closes browser")
    public void userClosesBrowser() {
        closeSite();
    }
}
