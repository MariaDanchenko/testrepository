package OOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
}
