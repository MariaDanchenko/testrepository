package hw.firsttestclasstest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest17 {

    private WebDriver driver;
    private LoginPage15 loginPage;

    @BeforeClass
    void initAndOpenSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage15(driver);
    }

    @AfterClass
    void closeDriver() {
        driver.quit();
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
    public void testLoginWithDifferentUsers(String username, String password, boolean shouldLoginSuccess) {

        System.out.println("Тестируем логин: " + username);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        driver.get("https://www.saucedemo.com/");
    }
}
