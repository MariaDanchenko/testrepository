package pageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        login("standard_user", "secret_sauce");
    }

    protected void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterCredentials(username, password);
        loginPage.clickLoginButton();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
