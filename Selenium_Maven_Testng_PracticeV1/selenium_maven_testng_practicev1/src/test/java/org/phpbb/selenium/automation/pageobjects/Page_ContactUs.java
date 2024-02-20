package org.phpbb.selenium.automation.pageobjects;

import org.phpbb.selenium.automation.common.*;
import org.phpbb.selenium.automation.initial.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page_ContactUs extends Initialize {

    WebDriverCommonActions action = new WebDriverCommonActions();

    @FindBy(xpath = "//select[@id='id_contact']")
    WebElement cs_subject_heading;

    @FindBy(xpath = "//input[@id='email']")
    WebElement cs_email;

    @FindBy(xpath = "//input[@id='id_order']")
    WebElement cs_idOrder;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement cs_message;

    @FindBy(xpath = "//button[@id='submitMessage']")
    WebElement cs_send_button;

    @FindBy(xpath = "//p[contains(@class,'alert-success')][contains(text(),'Your message has been successfully sent to our team')]")
    WebElement success_contact_message;

    public Page_ContactUs() {
        PageFactory.initElements(getDriver(), this);
    }

    public Select getSelectOptions() {
        return new Select(cs_subject_heading);
    }

    public void setSubject(String value) {
        getSelectOptions().selectByVisibleText(value);
    }

    public void writeEmail() {
        action.write(cs_email, property.getProperty("sign_in_user"));
    }

    public void writeOrderReference() {
        action.write(cs_idOrder, "1234567890");
    }

    public void writeMessage() {
        action.write(cs_message, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat");
    }

    public void click_SendContactForm() {
        action.click(cs_send_button);
    }

    public void fill_contact_form() {
        setSubject("Customer service");
        writeEmail();
        writeOrderReference();
        writeMessage();
        click_SendContactForm();
    }

    public boolean validateSuccessContactMessage() {
        return action.isDisplayed(success_contact_message);
    }

}