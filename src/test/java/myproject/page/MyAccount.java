package myproject.page;

import myproject.pagefragment.PageHeader;

import static myproject.pagefragment.TopBar.USERNAME_DETAILS;
import static utils.WebDriverUtils.elementShouldBeVisible;

public class MyAccount extends Page {

    private final String HEADER_TEXT = "MY ACCOUNT";

    private PageHeader pageHeader;

    public MyAccount(PageHeader pageHeader) {
        this.pageHeader = pageHeader;
    }

    public void expectElements() {
        pageHeader.verifyPageHeader(HEADER_TEXT);
        elementShouldBeVisible(USERNAME_DETAILS);
    }
}