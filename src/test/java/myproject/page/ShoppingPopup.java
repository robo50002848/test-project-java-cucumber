package myproject.page;

import org.openqa.selenium.By;

import static utils.WebDriverUtils.click;
import static utils.WebDriverUtils.elementShouldBeVisible;

class ShoppingPopup extends Page {

    private final By PRODUCT_ADDED_TEXT = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2");
    private final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".continue");
    private final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");

    void expectElements() {
        elementShouldBeVisible(PRODUCT_ADDED_TEXT);
        elementShouldBeVisible(CONTINUE_SHOPPING_BUTTON);
        elementShouldBeVisible(PROCEED_TO_CHECKOUT_BUTTON);
    }

    void continueShopping() {
        elementShouldBeVisible(CONTINUE_SHOPPING_BUTTON);
        click(CONTINUE_SHOPPING_BUTTON);
    }
}
