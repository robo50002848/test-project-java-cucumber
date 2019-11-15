package myproject.common;

import io.cucumber.java.en.When;
import myproject.page.Authentication;
import myproject.page.CreateAnAccount;
import myproject.pagefragment.PageHeader;

public class RegistrationSteps {

    private Authentication authentication;
    private CreateAnAccount createAnAccount;

    public RegistrationSteps() {
        PageHeader pageHeader = new PageHeader();
        authentication = new Authentication(pageHeader);
        createAnAccount = new CreateAnAccount(pageHeader);
    }

    @When("he fills the form with default data")
    public void registerUser() {
        authentication.logOut();
        authentication.expectElements();
        authentication.register();
        createAnAccount.expectElements();
        createAnAccount.fillRegistrationForm();
    }
}
