package myproject.page;

import myproject.pagefragment.PageHeader;
import org.openqa.selenium.By;

import static utils.WebDriverUtils.*;

public class CreateAnAccount extends Page {

    private static final By TITLE_MR = By.cssSelector("#uniform-id_gender1");
    private static final By FIRST_NAME_INPUT = By.cssSelector("#customer_firstname");
    private static final By LAST_NAME_INPUT = By.cssSelector("#customer_lastname");
    private static final By PASSWORD_INPUT = By.cssSelector("#passwd");
    private static final By ADDRESS_INPUT = By.cssSelector("#address1");
    private static final By CITY_INPUT = By.cssSelector("#city");
    private static final By STATE_DROPDOWN = By.cssSelector("#id_state");
    private static final By POSTAL_CODE_INPUT = By.cssSelector("#postcode");
    private static final By PHONE_NUMBER_INPUT = By.cssSelector("#phone_mobile");
    private static final By SUBMIT_BUTTON = By.cssSelector("#submitAccount");
    private static final String HEADER_TEXT = "CREATE AN ACCOUNT";
    private static final String FIRST_NAME_INPUT_TEXT = "Robert";
    private static final String LAST_NAME_INPUT_TEXT = "Franczak";
    private static final String PASSWORD_INPUT_TEXT = "qwerty123";
    private static final String ADDRESS_INPUT_TEXT = "Street 123";
    private static final String CITY_INPUT_TEXT = "City123";
    private static final String STATE_DROPDOWN_TEXT = "Alabama";
    private static final String POSTAL_CODE_INPUT_TEXT = "12345";
    private static final String PHONE_NUMBER_INPUT_TEXT = "123456789";

    private PageHeader pageHeader;

    public CreateAnAccount(PageHeader pageHeader) {
        this.pageHeader = pageHeader;
    }

    public void expectElements() {
        elementShouldBeVisible(TITLE_MR);
        pageHeader.verifyPageHeader(HEADER_TEXT);
    }

    public void fillRegistrationForm() {
        elementShouldBeVisible(TITLE_MR);
        click(TITLE_MR);
        fill(FIRST_NAME_INPUT, FIRST_NAME_INPUT_TEXT);
        fill(LAST_NAME_INPUT, LAST_NAME_INPUT_TEXT);
        fill(PASSWORD_INPUT, PASSWORD_INPUT_TEXT);
        fill(ADDRESS_INPUT, ADDRESS_INPUT_TEXT);
        fill(CITY_INPUT, CITY_INPUT_TEXT);
        selectOptionFromDropdown(STATE_DROPDOWN_TEXT, STATE_DROPDOWN);
        fill(POSTAL_CODE_INPUT, POSTAL_CODE_INPUT_TEXT);
        fill(PHONE_NUMBER_INPUT, PHONE_NUMBER_INPUT_TEXT);
        click(SUBMIT_BUTTON);
    }
}
