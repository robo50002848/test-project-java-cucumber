package myproject.page;

import myproject.pagefragment.PageHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static myproject.pagefragment.TopBar.USERNAME_DETAILS;
import static utils.WebDriverUtils.elementShouldBeVisible;
import static utils.WebDriverUtils.findElementsByCssSelector;

public class Cart extends Page {

    private final String HEADER_TEXT = "SHOPPING-CART SUMMARY";
    private final By PRODUCT_ITEM_ROW = By.cssSelector(".cart_item");

    private PageHeader pageHeader;

    public Cart(PageHeader pageHeader) {
        this.pageHeader = pageHeader;
    }

    public void expectElements() {
        pageHeader.verifyPageHeader(HEADER_TEXT);
        elementShouldBeVisible(USERNAME_DETAILS);
    }

    public void productsShouldBeVisible(int productsCount) {
        List<WebElement> results = findElementsByCssSelector(PRODUCT_ITEM_ROW);
        if (results.size() != productsCount) {
            throw new IllegalStateException("No products displayed.");
        }
    }
}
