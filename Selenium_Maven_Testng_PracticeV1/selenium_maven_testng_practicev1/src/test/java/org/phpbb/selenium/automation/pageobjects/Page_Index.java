package org.phpbb.selenium.automation.pageobjects;

import org.phpbb.selenium.automation.common.*;
import org.phpbb.selenium.automation.initial.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Index extends Initialize {

    WebDriverCommonActions action = new WebDriverCommonActions();

    @FindBy(xpath = "//a[@id='logo']")
    WebElement main_logo;

    @FindBy(xpath = "//a/span[contains(text(),'Quick links')]")
    WebElement topbar_quick_links;
    
    @FindBy(xpath = "//a/span[contains(text(),'FAQ')]")
    WebElement topbar_faq;
    
    @FindBy(xpath = "//a/span[contains(text(),'Register')]")
    WebElement topbar_register;
    
    @FindBy(xpath = "//a/span[contains(text(),'Login')]")
    WebElement topbar_login;

    public Page_Index() {
        PageFactory.initElements(getDriver(), this);
    }

    public void click_QuickLinks() {
        action.click(topbar_quick_links);
    }

    public void click_Faq() {
        action.click(topbar_faq);
    }

    public void click_Register() {
        action.click(topbar_register);
    }
    
    public void click_Login() {
        action.click(topbar_login);
    }

    public boolean validate_Logo() {
        action.waitForElement(main_logo);
        return action.isDisplayed(main_logo);
    }

    public boolean validate_RegisterButton() {
        action.waitForElement(topbar_register);
        return action.isDisplayed(topbar_register) && action.isEnabled(topbar_register);
    }

    public boolean validate_LoginButton() {
        action.waitForElement(topbar_login);
        return action.isDisplayed(topbar_login) && action.isEnabled(topbar_login);
    }


}