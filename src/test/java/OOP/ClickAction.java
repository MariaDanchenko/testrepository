package OOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickAction implements WebElementAction {

    private By locator;

    public ClickAction(By locator) {
        this.locator = locator;
    }

    @Override
    public void performAction(WebDriver driver) {
        driver.findElement(locator).click();
    }
}
