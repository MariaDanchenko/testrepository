package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextRetriever {

    private WebDriver driver;

    public TextRetriever(WebDriver driver) {
        this.driver = driver;
    }

    public TextRetriever() {}

    public <T> T getElementText(By locator, Class<T> type) {
        String text = driver.findElement(locator).getText();

        if (type.equals(String.class)) {
            return type.cast(text);
        } else if (type.equals(Integer.class)) {
            return type.cast(Integer.parseInt(text));
        } else if (type.equals(Double.class)) {
            return type.cast(Double.parseDouble(text));
        } else {
            throw new IllegalArgumentException("Unsupported type");
        }
    }

    public void testTextRetriever() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        TextRetriever textRetriever = new TextRetriever(driver);
        String firstItemName = textRetriever.getElementText(By.cssSelector(".inventory_item_name"), String.class);

        System.out.println("First product name: " + firstItemName);

        driver.quit();
    }

    public static void main(String[] args) {
        TextRetriever textRetriever = new TextRetriever();
        textRetriever.testTextRetriever();
    }
}
