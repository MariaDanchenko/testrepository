package patterns;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDifferentUsersTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void testLoginWithDifferentUsers(String username, String password, boolean isSuccessExpected) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (isSuccessExpected) {
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

            InventoryPage inventoryPage = new InventoryPage(driver); //добавила выход после успешного входа
            inventoryPage.logout();

        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", false}
        };
    }
}
