package exercises.eleven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PagesTest {

    private WebDriver driver;
    private PageValidator pageValidator;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        pageValidator = new PageValidator(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "pages")
    public Object[][] pages() {
            return new Object[][]{
                    {
                        "https://the-internet.herokuapp.com/checkboxes", By.tagName("h3"), "Checkboxes"
                    },
                    {
                        "https://the-internet.herokuapp.com/typos", By.tagName("h3"), "Typos"
                    },
                    {
                        "https://the-internet.herokuapp.com/dropdown", By.tagName("h3"), "Dropdown List"
                    }
            };
    }

    @Test(dataProvider = "pages")
    public void testPages(String url, By headerLocator, String expectedHeader) {
        driver.get(url);

        TestResult<String> result = pageValidator.validateHeader(headerLocator, String.class, expectedHeader);

        Assert.assertNotNull(result.getData());
    }
}
