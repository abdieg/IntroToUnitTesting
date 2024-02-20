package org.phpbb.selenium.automation.common;

import org.phpbb.selenium.automation.initial.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class WebDriverCommonActions extends Initialize {

    public void waitForElement(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

//        wait.until(ExpectedConditions.stalenessOf(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElement(List<WebElement> element) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

//        wait.until(ExpectedConditions.stalenessOf(element.get(0)));
        wait.until(ExpectedConditions.visibilityOf(element.get(0)));
        wait.until(ExpectedConditions.elementToBeClickable(element.get(0)));
    }

    public void waitForElementToHide(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitToBeGreater(WebElement element, String attr) {
        String original_value = element.getAttribute(attr);

        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(property.getProperty("timeout"))))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String new_value = element.getAttribute(attr);
                if (Integer.parseInt(new_value) > Integer.parseInt(original_value)) {
                    System.out.println("> Value expected got changed. Old value: " + original_value + " new value: " + new_value);
                    return true;
                }
                else {
                    System.out.println("> Nothing changed yet");
                    return false;
                }
            }
        });
    }

    public void write(WebElement element, String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        waitForElement(element);
        return element.isDisplayed();
    }

    public boolean isPresent(List<WebElement> element) { return element != null && element.size() > 0; }

    public boolean isEnabled(WebElement element) {
        waitForElement(element);
        return element.isEnabled();
    }

    public void hover(WebElement element) {
        Actions actions = new Actions(getDriver());
        waitForElement(element);
        if (property.getProperty("browser").equalsIgnoreCase("firefox")) {
            scrollToElement(element);
        }
        actions.moveToElement(element).perform();
    }

    public void hover_and_click(WebElement container, WebElement element) {
        hover(container);
        click(element);
    }

    public void goBack() {
        getDriver().navigate().back();
    }

    public Integer getRandomIndex(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public Integer getRandomNumber(int max) {
        Random rand = new Random();
        int min = 1;
        return rand.nextInt((max - min) + 1) + min;
    }

    public void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

}
