package org.phpbb.selenium.automation.pageobjects;

import org.phpbb.selenium.automation.common.*;
import org.phpbb.selenium.automation.initial.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Page_Item extends Initialize {

    WebDriverCommonActions action = new WebDriverCommonActions();

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement qty_field;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement size_field;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']//a")
    List<WebElement> color_field;

    @FindBy(xpath = "//p[@id='add_to_cart']//button")
    WebElement add_to_cart_button;

    @FindBy(xpath = "//div[@id='layer_cart']//span[contains(@title,'Close window')]")
    WebElement cart_popup_button_close_window;

    @FindBy(xpath = "//div[@id='layer_cart']//div[contains(@class,'product')]//h2") //Product successfully added to your shopping cart
    WebElement cart_popup_successful_message;

    @FindBy(xpath = "//div[@id='layer_cart']//div[contains(@class,'cart')]//span[@title='Continue shopping']")
    WebElement cart_popup_button_continue_shopping;

    @FindBy(xpath = "//div[@id='layer_cart']//div[contains(@class,'cart')]//a[@title='Proceed to checkout']")
    WebElement cart_popup_button_proceed_to_checkout;

    @FindBy(xpath = "//a[@id='wishlist_button']")
    WebElement wishlist_button;

    @FindBy(xpath = "//div[@class='fancybox-inner']//p[contains(text(),'Added to your wishlist')]")
    WebElement fancybox_message;

    @FindBy(xpath = "//div[contains(@class,'fancybox')]//a[@title='Close']")
    WebElement fancybox_close;

    public Page_Item() {
        PageFactory.initElements(getDriver(), this);
    }

    public void setQuantity(String text) { action.write(qty_field, text); }

    public Select getSelectOptions() {
        return new Select(size_field);
    }

    public void setSize(String value) {
        getSelectOptions().selectByVisibleText(value);
    }

    public void setRandomSize() {
        int numberOfOptions = getSelectOptions().getOptions().size();
        int randomOption = action.getRandomIndex(numberOfOptions);
        getSelectOptions().selectByIndex(randomOption);
    }

    public void setRandomColor() {
        System.out.println("Colors available for this product: " + color_field.size());
        System.out.println("Picking a random color");
        int randomColor = action.getRandomIndex(color_field.size());
        action.click(color_field.get(randomColor));
    }

    public void click_AddItemToCart() {
        action.click(add_to_cart_button);
    }

    public void click_ClosePopup() { action.click(cart_popup_button_close_window); }

    public void click_ContinueShopping() { action.click(cart_popup_button_continue_shopping); }

    public void click_ProceedCheckout() { action.click(cart_popup_button_proceed_to_checkout); }

    public void close_popup_and_continue_shopping() {
        action.waitForElement(cart_popup_successful_message);
        click_ContinueShopping();
        action.waitForElementToHide(cart_popup_successful_message);
    }

    public void click_WishlistButton() { action.click(wishlist_button); }

    public void close_fancybox() {
        action.waitForElement(fancybox_message);
        action.click(fancybox_close);
        action.waitForElementToHide(fancybox_message);
    }
}
