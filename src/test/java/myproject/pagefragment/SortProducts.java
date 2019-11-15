package myproject.pagefragment;

import myproject.page.Page;
import org.openqa.selenium.By;

import static utils.WebDriverUtils.selectOptionFromDropdown;

public class SortProducts extends Page {

    public static final String SORT_PRODUCTS_PRICE_LOWEST_FIRST_TEXT = "Price: Lowest first";
    public static final String SORT_PRODUCTS_PRODUCT_NAME_A_TO_Z_TEXT = "Product Name: A to Z";

    private final By SORT_PRODUCTS_DROPDOWN = By.cssSelector("#selectProductSort");

    public void sortProducts(String sortProductsOption) {
        selectOptionFromDropdown(sortProductsOption, SORT_PRODUCTS_DROPDOWN);
    }
}
