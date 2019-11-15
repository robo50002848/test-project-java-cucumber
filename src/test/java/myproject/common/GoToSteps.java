package myproject.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import myproject.page.Homepage;
import myproject.pagefragment.MainOptions;
import org.openqa.selenium.WebDriver;
import utils.WebDriverInit;

public class GoToSteps {

    private WebDriver webDriver;
    private Homepage homepage;
    private MainOptions mainOptions;

    public GoToSteps() {
        webDriver = WebDriverInit.getInstance().getWebDriver();
        mainOptions = new MainOptions();
        homepage = new Homepage();
    }

    @Given("user goes to the (.*) main page")
    public void goToThePage(String url) {
        webDriver.get(url);
    }

    @When("he goes to the authentication page")
    public void goToTheAuthenticationPage() {
        homepage.goToTheAuthenticationPage();
    }

    @When("he goes to the cart")
    public void heGoesToTheCart() {
        mainOptions.goToShoppingCart();
    }
}
