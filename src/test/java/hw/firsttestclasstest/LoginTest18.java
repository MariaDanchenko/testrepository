package hw.firsttestclasstest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest18 extends TestBase18 {

    private LoginPage15 loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage15(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true},  // корректные данные
                {"locked_out_user", "secret_sauce", false}, // заблокированный пользователь
                {"wrong_user", "wrong_pass", false} // некорректные данные
        };
    }

    @Test(dataProvider = "loginData")
    public void testLoginWithDifferentUsers(String username, String password, boolean shouldSuccess) {

        System.out.println("Тестируем логин: " + username);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        if (shouldSuccess) {
            Assert.assertEquals(
                    driver.getCurrentUrl(),
                    "https://www.saucedemo.com/inventory.html",
                    "Пользователь должен был успешно авторизоваться"
            );
        } else {
            String errorMessage = loginPage.getErrorMessage();
            Assert.assertTrue(
                    errorMessage.contains("Epic sadface"),
                    "Ожидалось сообщение об ошибке при неверном логине"
            );
        }
    }
}
