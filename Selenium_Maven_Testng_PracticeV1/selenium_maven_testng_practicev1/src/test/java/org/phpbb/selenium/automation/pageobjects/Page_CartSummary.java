package org.phpbb.selenium.automation.pageobjects;

import org.phpbb.selenium.automation.common.*;
import org.phpbb.selenium.automation.initial.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page_CartSummary extends Initialize {

    WebDriverCommonActions action = new WebDriverCommonActions();

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr")
    List<WebElement> products_added;

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr//td[contains(@class,'quantity')]//input[@type='hidden']")
    List<WebElement> current_quantity;

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr//td[contains(@class,'quantity')]//a[@title='Subtract']")
    List<WebElement> quantity_subtract;

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr//td[contains(@class,'quantity')]//a[@title='Add']")
    List<WebElement> quantity_add;

    public Page_CartSummary() {
        PageFactory.initElements(getDriver(), this);
    }

    public int getNumberOfProducts() {
        action.waitForElement(products_added);
        System.out.println("Number of products added: " + products_added.size());
        return products_added.size();
    }

    public Integer getProductQuantity(WebElement element) { return Integer.parseInt(element.getAttribute("value")); }

    public Integer[] getProductQuantities() {
        int totalProducts = getNumberOfProducts();
        Integer[] old_quantities = new Integer[totalProducts];

        for (int i = 0; i < totalProducts; i++) {
            System.out.println("Qty: " + getProductQuantity(current_quantity.get(i)));
            old_quantities[i] = getProductQuantity(current_quantity.get(i));
        }
        return old_quantities;
    }

    public void click_QtyAdd(int index) {
        action.waitForElement(quantity_add);
        action.click(quantity_add.get(index));
        action.waitToBeGreater(current_quantity.get(index), "value");
    }

}
