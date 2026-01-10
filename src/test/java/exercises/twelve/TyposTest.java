package exercises.twelve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TyposTest {

    private WebDriver driver;
    private TyposPage typosPage;
    private final Logger logger = LogManager.getLogger(TyposTest.class.getName());

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/typos");

        typosPage = new TyposPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testTypos() {
        String headerText = typosPage.getHeaderText();
        String typoText = typosPage.getTypoText();
        boolean hasTypo = typosPage.containsTypo();

        logger.info("Page header text: " + headerText);
        logger.info("Paragraph text " + typoText);

        if (hasTypo) {
            logger.warn("Typo detected on the page");
        } else {
            logger.info("No typos detected on the page");
        }

        Assert.assertNotNull(headerText);
        Assert.assertFalse(headerText.isEmpty());
    }
}
