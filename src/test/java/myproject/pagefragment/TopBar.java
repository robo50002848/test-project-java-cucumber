package myproject.pagefragment;

import myproject.page.Page;
import org.openqa.selenium.By;

public class TopBar extends Page {

    public static final By SIGN_IN = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    public static final By SIGN_OUT = By.cssSelector(".logout");
    public static final By USERNAME_DETAILS = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a");
}
