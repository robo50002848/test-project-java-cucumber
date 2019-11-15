package myproject.page;

import myproject.pagefragment.BuyBlock;

import static utils.WebDriverUtils.elementShouldBeVisible;

public class ProductsDetails extends Page {

    private BuyBlock buyBlock = new BuyBlock();

    public void expectElements() {
        elementShouldBeVisible(buyBlock.ADD_TO_CART_BUTTON);
    }

    public void addToCart() {
        buyBlock.addToCart();
    }
}
