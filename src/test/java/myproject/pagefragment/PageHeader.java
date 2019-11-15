package myproject.pagefragment;

import myproject.page.Page;
import org.openqa.selenium.By;

import static utils.WebDriverUtils.elementShouldBeVisible;
import static utils.WebDriverUtils.elementShouldContainText;

public class PageHeader extends Page {

    private final By PAGE_HEADER = By.cssSelector(".page-heading");

    public final void verifyPageHeader(String header) {
        elementShouldBeVisible(PAGE_HEADER);
        elementShouldContainText(PAGE_HEADER, header);
    }
}