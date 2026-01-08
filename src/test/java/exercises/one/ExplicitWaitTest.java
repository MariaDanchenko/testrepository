package exercises.one;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ExplicitWaitTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void firstLink() {
        driver.findElement(By.cssSelector("a[href='/dynamic_loading/1']")).click();

        WebElement startButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='start']/button")));

        startButton.click();

        WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h4[contains(text(), 'Hello World!')]")));

        Assert.assertEquals(resultText.getText(), "Hello World!");
    }

    @Test
    public void secondLink() {
        driver.findElement(By.cssSelector("a[href='/dynamic_loading/2']")).click();

        WebElement startButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='start']/button")));

        startButton.click();

        WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h4[contains(text(), 'Hello World!')]")));

        Assert.assertEquals(resultText.getText(), "Hello World!");
    }
}
