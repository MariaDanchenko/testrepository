package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By exampleOne = By.cssSelector("a[href ='/dynamic_loading/1']");
    private final By exampleTwo = By.cssSelector("a[href ='/dynamic_loading/2']");
    private final By startButton = By.xpath("//div[@id='start']/button");
    private final By finishText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openExampleOne() {
        driver.findElement(exampleOne).click();
    }

    public void openExampleTwo() {
        driver.findElement(exampleTwo).click();
    }

    public void clickStart() {
        driver.findElement(startButton).click();
    }

    public String waitForText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishText));
        return driver.findElement(finishText).getText();
    }
}
