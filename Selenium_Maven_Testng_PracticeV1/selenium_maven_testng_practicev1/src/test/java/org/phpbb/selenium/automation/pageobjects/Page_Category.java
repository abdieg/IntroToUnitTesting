package org.phpbb.selenium.automation.pageobjects;

import org.phpbb.selenium.automation.common.*;
import org.phpbb.selenium.automation.initial.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page_Category extends Initialize {

    WebDriverCommonActions action = new WebDriverCommonActions();

    Page_Item page_item = new Page_Item();

    @FindBy(xpath = "//div[@class='product-container']")
    List<WebElement> product_container;

    @FindBy(xpath = "//li[contains(@class,'hovered')]//div[@class='product-container']//a/span[contains(text(),'More')]")
    WebElement product_container_more_button;

    public Page_Category() {
        PageFactory.initElements(getDriver(), this);
    }

    public void click_MoreButton(WebElement container, WebElement element) {
        action.hover_and_click(container, element);
    }

    public void add_random_items_in_this_category_to_cart() {
        System.out.println("Number of products in this category: " + product_container.size());
        System.out.println("Hover over a random product in this category");
        int randomElement = action.getRandomIndex(product_container.size());
        System.out.println("Random element selected: " + randomElement);
        click_MoreButton(product_container.get(randomElement), product_container_more_button);
        page_item.setQuantity(action.getRandomNumber(10).toString());
        page_item.setRandomSize();
        page_item.setRandomColor();
        page_item.click_AddItemToCart();
        page_item.close_popup_and_continue_shopping();
        action.goBack();
    }

    public void add_random_items_in_this_category_to_wishlist() {
        System.out.println("Number of products in this category: " + product_container.size());
        System.out.println("Hover over a random product in this category");
        int randomElement = action.getRandomIndex(product_container.size());
        System.out.println("Random element selected: " + randomElement);
        click_MoreButton(product_container.get(randomElement), product_container_more_button);
        page_item.click_WishlistButton();
        page_item.close_fancybox();
    }

    public void add_specific_items_in_this_category_to_cart(String _qty, String _size) {
        System.out.println("Number of products in this category: " + product_container.size());
        System.out.println("Hover over a random product in this category");
        int randomElement = action.getRandomNumber(product_container.size());
        System.out.println("Random element selected: " + randomElement);
        click_MoreButton(product_container.get(randomElement), product_container_more_button);
        page_item.setQuantity(_qty);
        page_item.setSize(_size);
        page_item.setRandomColor();
        page_item.click_AddItemToCart();
        page_item.close_popup_and_continue_shopping();
        action.goBack();
    }

}
