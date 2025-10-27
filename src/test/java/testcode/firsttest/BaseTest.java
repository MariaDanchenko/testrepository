package testcode.firsttest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    protected String baseUrl = "https://the-internet.herokuapp.com/";
    protected String browser = "firefox";

    @BeforeClass
    void setUp() {
        initDriver();
        driver.get(baseUrl);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForPageLoad();
    }

    protected void initDriver() {
        if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    protected void waitForPageLoad() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Welcome to the-internet']")
        ));
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
