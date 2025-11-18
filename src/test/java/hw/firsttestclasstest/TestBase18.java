package hw.firsttestclasstest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase18 {

    protected WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @BeforeMethod
    void openLoginPageBeforeEachTest() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
