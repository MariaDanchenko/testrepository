package patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithInvalidPasswordTest extends BaseTest {


    @Test
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user"));
    }
}
