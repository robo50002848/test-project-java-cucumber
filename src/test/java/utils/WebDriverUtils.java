package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverUtils {

    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;

    static {
        webDriver = WebDriverInit.getInstance().getWebDriver();
        webDriverWait = WebDriverInit.getInstance().getWebDriverWait();
    }

    public static void click(By cssSelector) {
        findElementByCssSelector(cssSelector).click();
    }

    public static void fill(By cssSelector, String value) {
        findElementByCssSelector(cssSelector).sendKeys(value);
    }

    private static String getTextFromElement(By cssSelector) {
        return findElementByCssSelector(cssSelector).getText();
    }

    public static void elementShouldContainText(By csSelector, String text) {
        if (!getTextFromElement(csSelector).contains(text)) {
            throw new IllegalStateException("Element does not contain provided text.");
        }
    }

    public static void elementShouldBeVisible(By cssSelector) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector));
    }

    public static boolean checkIfElementIsDisplayed(By cssSelector) {
        return findElementByCssSelector(cssSelector).isDisplayed();
    }

    public static void selectOptionFromDropdown(String option, By cssSelector) {
        Select select = new Select(findElementByCssSelector(cssSelector));
        select.selectByVisibleText(option);
    }

    public static void moveMouseToElement(WebElement webElement) {
        Actions action = new Actions(webDriver);
        action.moveToElement(webElement).perform();
    }

    public static WebElement findElementByCssSelector(By cssSelector) {
        return findElementsByCssSelector(cssSelector).get(0);
    }

    public static List<WebElement> findElementsByCssSelector(By cssSelector) {
        try {
            return webDriver.findElements(cssSelector);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Element not found.", e);
        }
    }

    public static void deleteAllCookies() {
        webDriver.manage().deleteAllCookies();
    }

    public static void quitDriver() {
        webDriver.quit();
    }
}
