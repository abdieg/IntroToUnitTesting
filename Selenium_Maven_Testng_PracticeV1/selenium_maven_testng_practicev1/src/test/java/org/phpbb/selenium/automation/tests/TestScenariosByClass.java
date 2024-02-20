package org.phpbb.selenium.automation.tests;

import org.phpbb.selenium.automation.initial.*;
import org.phpbb.selenium.automation.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestScenariosByClass extends Initialize {

    Page_Index page_index;
    Page_Authentication page_auth;
    Page_Account page_account;
    Page_ContactUs page_contact;
    Page_Category page_category;
    Page_CartSummary page_cartsummary;

    @Parameters ({ "browser" })
	/*
	 * #############################################################################
	 * USE BELOW WHEN TESTNG NEEDS TO BE USED
	 * #############################################################################
	 */
    @BeforeClass (alwaysRun = true)
    public void setup(String browserName) {
        setDriver(browserName);
    }

//	/*
//	 * #############################################################################
//	 * USE BELOW WHEN EXECUTING SINGLE TESTS IN ECLIPSE
//	 * #############################################################################
//	 */
//    @BeforeClass
//    public void setup() {
//        setDriver();
//    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void test_verify_logo() {
        page_index = new Page_Index();
        System.out.println("Verifying logo");
        Assert.assertTrue(page_index.validate_Logo());
    }

    @Test
    public void test_verify_register_button() {
        page_index = new Page_Index();
        System.out.println("Verifying register button");
        Assert.assertTrue(page_index.validate_RegisterButton());
    }

    @Test
    public void test_verify_login_button() {
        page_index = new Page_Index();
        System.out.println("Verifying log in button");
        Assert.assertTrue(page_index.validate_LoginButton());
    }
}
