package hw.firsttestclasstest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginTest16 {

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
}
