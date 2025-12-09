package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DragAndDropPage {

    private WebDriver driver;

    private final By boxA = By.id("column-a");
    private final By boxB = By.id("column-b");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBoxA() {
        return driver.findElement(boxA);
    }

    public WebElement getBoxB() {
        return driver.findElement(boxB);
    }

    public void dragAtoB() {
        Actions actions = new Actions(driver);

        WebElement source = getBoxA();
        WebElement target = getBoxB();

        actions.dragAndDrop(source, target).build().perform();
    }
}
