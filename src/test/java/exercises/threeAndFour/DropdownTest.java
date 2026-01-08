package exercises.threeAndFour;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DropdownTest {

    private WebDriver driver;
    private DropdownPage dropdownPage;
    private final Logger logger = LogManager.getLogger(DropdownTest.class);

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        dropdownPage = new DropdownPage(driver);

        logger.info("Browser started");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

        logger.info("Browser closed");
    }

    @Test
    public void testSelectOption() {
        dropdownPage.selectOptionOne();
        logger.info("Select Option 1");

        String selectedOptionOne = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOptionOne, "Option 1");
        logger.info("Option 1 selected");

        dropdownPage.selectOptionTwo();
        logger.info("Select Option 2");

        String selectedOptionTwo = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOptionTwo, "Option 2");
        logger.info("Option 2 selected");
    }
}
