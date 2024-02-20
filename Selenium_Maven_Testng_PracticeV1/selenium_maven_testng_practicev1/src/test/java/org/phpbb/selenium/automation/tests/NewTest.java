package org.phpbb.selenium.automation.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class NewTest {

    @Test
    public void testTestNGDependency() {
        // This test simply asserts that TestNG is available
        Assert.assertTrue(true);
    }

    @Test
    public void testFirefoxDriverDependency() {
        // This test validates that FirefoxDriver can be instantiated
        WebDriver driver = new FirefoxDriver();
        driver.quit();
    }
}

