package myproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverInit;

public abstract class Page {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public Page() {
        webDriver = WebDriverInit.getInstance().getWebDriver();
        webDriverWait = WebDriverInit.getInstance().getWebDriverWait();
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    protected WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
