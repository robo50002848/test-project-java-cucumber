package myproject.common;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.page.ProductsDetails;
import myproject.page.SearchResults;
import myproject.pagefragment.MainOptions;
import myproject.pagefragment.PageHeader;

public class ProductsSteps {

    private SearchResults searchResults;
    private MainOptions mainOptions;
    private ProductsDetails productsDetails;

    public ProductsSteps() {
        PageHeader pageHeader = new PageHeader();
        mainOptions = new MainOptions();
        searchResults = new SearchResults(pageHeader);
        productsDetails = new ProductsDetails();
    }

    @When("he searches for (.*) product")
    public void searchForProduct(String product) {
        mainOptions.search(product);
        searchResults.expectElements();
        searchResults.resultsShouldBeVisible();
    }

    @Then("he should see results")
    public void shouldSeeResult() {
        searchResults.expectElements();
        searchResults.resultsShouldBeVisible();
    }

    @And("he adds product number (.*) to the cart")
    public void heAddsProductToTheCart(int productNumber) {
        searchResults.expectElements();
        searchResults.addProductToCart(productNumber);
    }

    @And("he adds product number (.*) to the cart from product's details page")
    public void heAddsIndifferentProductToTheCartFromProductSDetailsPage(int productNumber) {
        searchResults.expectElements();
        searchResults.goToProductsDetailsPage(productNumber);
        productsDetails.expectElements();
        productsDetails.addToCart();
    }

    @When("he sorts products by (.*)")
    public void heSortsProductsBySortOption(String sortProductsOption) {
        searchResults.sortProducts(sortProductsOption);
    }

    @Then("products are sorted by (.*)")
    public void productsAreSortedBySortOption(String sortProductsOption) {
        searchResults.expectElements();
        searchResults.productsShouldBeSortedBySortOption(sortProductsOption);
    }
}
