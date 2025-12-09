package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage {

    private final WebDriver driver;
    private final By checkboxLocator = By.xpath("//form[@id='checkboxes']/input[1]");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public WebElement getCheckbox() {
        return driver.findElement(checkboxLocator);
    }
}
