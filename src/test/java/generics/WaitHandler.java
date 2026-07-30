package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHandler {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHandler(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WaitHandler() {}

    public <T> WebElement waitForElement(T element) {

        if (element instanceof By) {
            return wait.until(ExpectedConditions.elementToBeClickable((By) element));
        } else if (element instanceof WebElement) {
            return wait.until(ExpectedConditions.elementToBeClickable((WebElement) element));
        } else {
            throw new IllegalArgumentException("Unsupported type for waiting");
        }
    }

    public void testWaitHandler() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WaitHandler waitHandler = new WaitHandler(driver);

        WebElement loginButton = waitHandler.waitForElement(By.id("login-button"));

        loginButton.click();

        driver.quit();
    }

    public static void main(String[] args) {
        WaitHandler waitHandler = new WaitHandler();
        waitHandler.testWaitHandler();
    }
}
