package myproject.page;

import static myproject.pagefragment.TopBar.SIGN_IN;
import static utils.WebDriverUtils.click;
import static utils.WebDriverUtils.elementShouldBeVisible;

public class Homepage extends Page {

    public void goToTheAuthenticationPage() {
        elementShouldBeVisible(SIGN_IN);
        click(SIGN_IN);
    }
}
