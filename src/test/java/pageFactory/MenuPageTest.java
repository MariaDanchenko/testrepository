package pageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuPageTest extends BaseTest {

    @Test
    public void testMenuPage() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.openMenu();
        menuPage.logout();

        Assert.assertTrue(menuPage.isUserLogout());
    }
}
