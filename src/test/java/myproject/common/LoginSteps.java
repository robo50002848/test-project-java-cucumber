package myproject.common;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.page.Authentication;
import myproject.page.Homepage;
import myproject.page.MyAccount;
import myproject.pagefragment.PageHeader;

public class LoginSteps {

    private Homepage homepage;
    private Authentication authentication;
    private MyAccount myAccount;

    public LoginSteps() {
        PageHeader pageHeader = new PageHeader();
        homepage = new Homepage();
        myAccount = new MyAccount(pageHeader);
        authentication = new Authentication(pageHeader);
    }

    @And("he enter (.*) and (.*) credentials")
    public void enterLoginCredentials(String emailAddress, String password) {
        authentication.expectElements();
        authentication.logIn(emailAddress, password);
    }

    @And("he logs in with default credentials")
    public void logIn() {
        homepage.goToTheAuthenticationPage();
        enterLoginCredentials(authentication.getDefaultEmail(), authentication.getDefaultPassword());
    }

    @Then("he is logged in and my account page is displayed")
    public void userShouldBeLoggedIn() {
        myAccount.expectElements();
    }

    @When("he logs in with (.*) and (.*) credentials")
    public void heLogsInWithLoginAndPasswordCredentials(String emailAddress, String password) {
        authentication.logOut();
        authentication.expectElements();
        authentication.logIn(emailAddress, password);
    }
}
