package myproject.common;

import io.cucumber.java.en.Then;
import myproject.page.Cart;
import myproject.pagefragment.PageHeader;

public class CartSteps {

    private Cart cart;

    public CartSteps() {
        PageHeader pageHeader = new PageHeader();
        cart = new Cart(pageHeader);
    }

    @Then("he should see (.*) products added to the cart")
    public void heShouldSeeProductsAddedToTheCart(int productsCount) {
        cart.expectElements();
        cart.productsShouldBeVisible(productsCount);
    }
}
