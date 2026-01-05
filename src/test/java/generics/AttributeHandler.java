package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeHandler {

    private WebDriver driver;

    public AttributeHandler(WebDriver driver) {

        this.driver = driver;
    }

    public AttributeHandler() {}

    public <T> T getAttributeValue(Object element, String attribute, Class<T> type) {
        String value;

        if (element instanceof By) {
            value = driver.findElement((By) element).getAttribute(attribute);
        } else {
            throw new IllegalArgumentException("Unsupported element type");
        }

        if (type.equals(String.class)) {
            return type.cast(value);
        } else if (type.equals(Integer.class)) {
            return type.cast(Integer.parseInt(value));
        } else {
            throw new IllegalArgumentException("Unsupported return type");
        }
    }

    public void testAttributeValue() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        AttributeHandler attributeHandler = new AttributeHandler(driver);

        String typeAttr = attributeHandler.getAttributeValue(
                By.id("login-button"), "type", String.class);

        System.out.println("Login button type: " + typeAttr);

        driver.quit();
    }

    public static void main(String[] args) {
        AttributeHandler attributeHandler = new AttributeHandler();
        attributeHandler.testAttributeValue();
    }
}
