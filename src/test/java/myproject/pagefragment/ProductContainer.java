package myproject.pagefragment;

import myproject.page.Page;
import org.openqa.selenium.By;

import static utils.WebDriverUtils.click;
import static utils.WebDriverUtils.elementShouldBeVisible;

public class ProductContainer extends Page {

    private final By ADD_TO_CART_BUTTON = By.cssSelector(".ajax_add_to_cart_button");

    public void addToCart() {
        elementShouldBeVisible(ADD_TO_CART_BUTTON);
        click(ADD_TO_CART_BUTTON);
    }
}
