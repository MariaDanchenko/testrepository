package exercises;

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

@Listeners(ElementWrapperListener.class)
public class ElementWrapperTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDynamicLoading() {
        WebElement link = driver.findElement(By.cssSelector("a[href = '/dynamic_loading']"));
        link.click();

        WebElement linkExampleOne = driver.findElement(By.cssSelector("a[href = '/dynamic_loading/1']"));
        linkExampleOne.click();

        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));

        ElementWrapper<WebElement> buttonWrapper = new ElementWrapper<>(startButton);

        buttonWrapper.getElement().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h4[text()='Hello World!']")));

        Assert.assertEquals(result.getText(), "Hello World!");
    }

    @Test
    public void testABTesting() {
        WebElement link = driver.findElement(By.cssSelector("a[href='/abtest']"));
        link.click();

        WebElement title = driver.findElement(By.cssSelector("h3"));
        ElementWrapper<WebElement> titleWrapper = new ElementWrapper<>(title);

        String titleText = titleWrapper.getElement().getText();

        Assert.assertTrue(titleText.contains("A/B Test"));
    }
}
