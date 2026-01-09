package exercises.eight;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

public class DynamicLoadingPageTest {

    private WebDriver driver;
    private DynamicLoadingPage dynamicLoadingPage;
    private final Logger logger = LogManager.getLogger(DynamicLoadingPageTest.class);

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        logger.info("Browser started");

        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }

    @Test
    public void testDynamicLoadingPage() {
        dynamicLoadingPage.clickLink();
        logger.info("Click link");

        dynamicLoadingPage.clickStartButton();
        logger.info("Click Start button");

        Assert.assertEquals(dynamicLoadingPage.getLoadingMessage(), "Hello World!");
        logger.info("Successful loading");
    }
}
