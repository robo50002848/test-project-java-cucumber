package myproject.pagefragment;

import myproject.page.Page;
import org.openqa.selenium.By;

import static utils.WebDriverUtils.click;
import static utils.WebDriverUtils.fill;

public class MainOptions extends Page {

    private static final By SEARCH_BOX_INPUT = By.cssSelector("#search_query_top");
    private static final By SEARCH_BOX_LOUPE_BUTTON = By.cssSelector("#searchbox > button");
    private static final By SHOPPING_CART_BUTTON = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");

    public void search(String product) {
        fill(SEARCH_BOX_INPUT, product);
        click(SEARCH_BOX_LOUPE_BUTTON);
    }

    public void goToShoppingCart() {
        click(SHOPPING_CART_BUTTON);
    }
}
