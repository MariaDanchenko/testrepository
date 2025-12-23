package logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CartTest {

    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(CartTest.class);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
    }


}
