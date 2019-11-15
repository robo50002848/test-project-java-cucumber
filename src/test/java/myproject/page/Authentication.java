package myproject.page;

import myproject.pagefragment.PageHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.MailGenerator;

import java.util.List;

import static myproject.pagefragment.TopBar.SIGN_OUT;
import static utils.WebDriverUtils.*;

public class Authentication extends Page {

    private static final By EMAIL_ADDRESS = By.cssSelector("#email");
    private static final By PASSWORD = By.cssSelector("#passwd");
    private static final By SIGN_IN = By.cssSelector("#SubmitLogin");
    private static final By CREATE_AN_ACCOUNT_EMAIL_ADDRESS_INPUT = By.cssSelector("#email_create");
    private static final By CREATE_AN_ACCOUNT_EMAIL_BUTTON = By.cssSelector("#SubmitCreate");
    private static final String HEADER_TEXT = "AUTHENTICATION";
    private static final String DEFAULT_EMAIL_TEXT = "defnrbjefkdm3848@mailinator.com";
    private static final String DEFAULT_PASSWORD_TEXT = "rrrrr";

    private PageHeader pageHeader;
    private MailGenerator mailGenerator;

    public Authentication(PageHeader pageHeader) {
        this.pageHeader = pageHeader;
        mailGenerator = new MailGenerator();
    }

    public void expectElements() {
        pageHeader.verifyPageHeader(HEADER_TEXT);
    }

    public String getDefaultEmail() {
        return DEFAULT_EMAIL_TEXT;
    }

    public String getDefaultPassword() {
        return DEFAULT_PASSWORD_TEXT;
    }

    public void logIn(String emailAddress, String password) {
        elementShouldBeVisible(EMAIL_ADDRESS);
        fill(EMAIL_ADDRESS, emailAddress);
        fill(PASSWORD, password);
        click(SIGN_IN);
    }

    public void logOut() {
        List<WebElement> list = findElementsByCssSelector(SIGN_OUT);
        if (!list.isEmpty()) {
            click(SIGN_OUT);
            expectElements();
        }
    }

    public void register() {
        elementShouldBeVisible(CREATE_AN_ACCOUNT_EMAIL_ADDRESS_INPUT);
        fill(CREATE_AN_ACCOUNT_EMAIL_ADDRESS_INPUT, mailGenerator.getGeneratedEmail());
        click(CREATE_AN_ACCOUNT_EMAIL_BUTTON);
    }
}
