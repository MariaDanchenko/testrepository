package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage12 {

    protected WebDriver driver;

    public BasePage12 (WebDriver driver) {

        this.driver = driver;
    }

    protected void clickElement(By locator) {

        WebElement element = driver.findElement(locator);
        element.click();
    }

    protected void enterText(By locator, String text) {

        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    protected WebElement waitForElement(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
