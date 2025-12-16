package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableHandler {

    private WebDriver driver;

    public TableHandler(WebDriver driver) {
        this.driver = driver;
    }

    public TableHandler() {}

    public <T> T getTableCellValue(By locator, Class<T> type) {
        String text = driver.findElement(locator).getText();

        if (type.equals(String.class)) {
            return type.cast(text);
        } else if (type.equals(Integer.class)) {
            return type.cast(Integer.parseInt(text));
        } else if (type.equals(Double.class)) {
            return type.cast(Double.parseDouble(text.replace("$", "")));
        } else {
            throw new IllegalArgumentException("Unsupported type");
        }
    }

    public void testTableHandler() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.cssSelector(".inventory_item button")).click();

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        TableHandler tableHandler = new TableHandler(driver);

        String itemName = tableHandler.getTableCellValue(
                By.cssSelector(".inventory_item_name"), String.class);

        Double priceItem = tableHandler.getTableCellValue(
                By.cssSelector(".inventory_item_price"), Double.class);

        System.out.println("Item name: " + itemName);
        System.out.println("Item price: " + priceItem + "$");

        driver.quit();
    }

    public static void main(String[] args) {
        TableHandler tableHandler = new TableHandler();
        tableHandler.testTableHandler();
    }
}
