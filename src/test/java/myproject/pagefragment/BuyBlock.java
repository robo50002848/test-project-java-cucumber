package myproject.pagefragment;

import myproject.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WebDriverUtils.click;

public class BuyBlock extends Page {

    public final By ADD_TO_CART_BUTTON = By.cssSelector("#add_to_cart > button");

    public void addToCart() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON));
        click(ADD_TO_CART_BUTTON);
    }
}
