package org.phpbb.selenium.automation.pageobjects;

import org.phpbb.selenium.automation.common.*;
import org.phpbb.selenium.automation.initial.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page_Account extends Initialize {

    WebDriverCommonActions action = new WebDriverCommonActions();

    @FindBy(xpath = "//span[contains(text(),'My account')]")
    WebElement my_account_text;

    @FindBy(xpath = "//ul/li/a/span[contains(text(),'Order history and details')]")
    WebElement account_order_history;

    @FindBy(xpath = "//ul/li/a/span[contains(text(),'My credit slips')]")
    WebElement account_credit_slips;

    @FindBy(xpath = "//ul/li/a/span[contains(text(),'My addresses')]")
    WebElement account_addresses;

    @FindBy(xpath = "//ul/li/a/span[contains(text(),'My personal information')]")
    WebElement account_personal_information;

    @FindBy(xpath = "//ul/li/a/span[contains(text(),'My wishlists')]")
    WebElement account_wishlists;

    @FindBy(xpath = "//a[@title='View my customer account']")
    WebElement account_customer_account;

    @FindBy(xpath = "//tr[contains(@id,'wishlist')]//a[contains(text(),'My wishlist')]")
    List<WebElement> wishlist_open_details;

    @FindBy(xpath = "//div[@class='wishlistLinkTop']//p[@class='product-name']")
    List<WebElement> wishlist_products;

    @FindBy(xpath = "//tr[contains(@id,'wishlist')]/td[@class='wishlist_delete']/a")
    WebElement wishlist_delete;

    public Page_Account() {
        PageFactory.initElements(getDriver(), this);
    }

    public void click_MyWishlists() {
        action.click(account_wishlists);
    }

    public boolean doesWishlistExist() {
        return action.isPresent(wishlist_open_details);
    }

    public void click_OpenWishlistDetails() {
        action.click(wishlist_open_details.get(0));
    }

    public void click_WishlistDelete() {
        action.click(wishlist_delete);
        action.acceptAlert();
    }

    public boolean validateAccountActions() {
        action.waitForElement(my_account_text);
        action.waitForElement(account_order_history);
        action.waitForElement(account_credit_slips);
        action.waitForElement(account_addresses);
        action.waitForElement(account_personal_information);
        action.waitForElement(account_wishlists);
        action.waitForElement(account_customer_account);

        return action.isDisplayed(my_account_text) &&
                action.isDisplayed(account_order_history) &&
                action.isDisplayed(account_credit_slips) &&
                action.isDisplayed(account_addresses) &&
                action.isDisplayed(account_personal_information) &&
                action.isDisplayed(account_wishlists) &&
                action.isDisplayed(account_customer_account);
    }

    public int getNumberOfProductsInWishlist() {
        action.waitForElement(wishlist_products);
        System.out.println("Number of products in wishlist: " + wishlist_products.size());
        return wishlist_products.size();
    }

}

