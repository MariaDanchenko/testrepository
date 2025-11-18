package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage3 {

    protected WebDriver driver;

    public BasePage3 (WebDriver driver) {

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
}
