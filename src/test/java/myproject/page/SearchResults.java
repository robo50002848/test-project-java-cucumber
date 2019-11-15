package myproject.page;

import com.google.common.collect.Ordering;
import myproject.pagefragment.PageHeader;
import myproject.pagefragment.ProductContainer;
import myproject.pagefragment.SortProducts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.WebDriverUtils.findElementsByCssSelector;
import static utils.WebDriverUtils.moveMouseToElement;

public class SearchResults extends Page {

    private final String HEADER_TEXT = "SEARCH";

    private final By RESULTS_CONTAINER_ITEM = By.cssSelector(".product-container");
    private final By PRODUCT_PRICE = By.cssSelector(".price.product-price");
    private final By PRODUCT_NAME = By.cssSelector(".right-block .product-name");

    private PageHeader pageHeader;
    private ProductContainer productContainer = new ProductContainer();
    private ShoppingPopup shoppingPopup = new ShoppingPopup();
    private SortProducts sortProducts = new SortProducts();

    public SearchResults(PageHeader pageHeader) {
        this.pageHeader = pageHeader;
    }

    public void expectElements() {
        pageHeader.verifyPageHeader(HEADER_TEXT);
    }

    public List<WebElement> resultsShouldBeVisible() {
        List<WebElement> results = findElementsByCssSelector(RESULTS_CONTAINER_ITEM);
        if (results.size() <= 0) {
            throw new IllegalStateException("No results displayed.");
        }
        return results;
    }

    private void showProductContainerOptions(int productNumber) {
        WebElement product = resultsShouldBeVisible().get(productNumber - 1);
        moveMouseToElement(product);
    }

    public void goToProductsDetailsPage(int productNumber) {
        WebElement product = resultsShouldBeVisible().get(productNumber - 1);
        product.click();
    }

    public void addProductToCart(int productNumber) {
        showProductContainerOptions(productNumber);
        productContainer.addToCart();
        shoppingPopup.expectElements();
        shoppingPopup.continueShopping();
    }

    public void sortProducts(String sortProductsOption) {
        sortProducts.sortProducts(sortProductsOption);
    }

    private List<Double> getProductsPrices() {
        List<WebElement> pricesAsWebElements = findElementsByCssSelector(PRODUCT_PRICE);
        List<String> pricesAsStrings = new ArrayList<>();
        List<Double> pricesAsDoubles = new ArrayList<>();
        for (WebElement element : pricesAsWebElements) {
            String priceAsString = element.getText();
            pricesAsStrings.add(priceAsString);
        }
        pricesAsStrings.removeAll(Arrays.asList("", null));
        for (String element : pricesAsStrings) {
            Double resultDouble = Double.parseDouble(element.substring(1));
            pricesAsDoubles.add(resultDouble);
        }
        return pricesAsDoubles;
    }

    private List<String> getProductsNames() {
        List<WebElement> list = findElementsByCssSelector(PRODUCT_NAME);
        List<String> namesAsStrings = new ArrayList<>();
        for (WebElement element : list) {
            namesAsStrings.add(element.getText());
        }
        return namesAsStrings;
    }

    private void productsShouldBeSortedByPriceLowestFirst() {
        List<Double> list = getProductsPrices();
        for (int i = 0; i < list.size() - 1; i++) {
            if (!(list.get(i) < list.get(i + 1))) {
                throw new IllegalStateException("Products are not sorted by Price: Lowest first");
            }
        }
    }

    private void productsShouldBeSortedByProductNameAToZ() {
        List<String> list = getProductsNames();
        if (!Ordering.natural().isOrdered(list)) {
            throw new IllegalStateException("Products are not sorted by Product Name: A to Z");
        }
    }

    public void productsShouldBeSortedBySortOption(String sortProductsOption) {
        switch (sortProductsOption) {
            case SortProducts.SORT_PRODUCTS_PRICE_LOWEST_FIRST_TEXT:
                productsShouldBeSortedByPriceLowestFirst();
                break;
            case SortProducts.SORT_PRODUCTS_PRODUCT_NAME_A_TO_Z_TEXT:
                productsShouldBeSortedByProductNameAToZ();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sortProductsOption);
        }
    }
}
