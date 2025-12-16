package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandler {

    public WebDriver driver;

    public DropdownHandler(WebDriver driver) {
        this.driver = driver;
    }

    public DropdownHandler () {}

    public <T> void selectDropdownValue(By locator, T value) {
        Select dropdown = new Select(driver.findElement(locator));

        if (value instanceof String) {
            dropdown.selectByVisibleText((String) value);
        } else if (value instanceof Integer) {
            dropdown.selectByIndex((Integer) value);
        } else {
            throw new IllegalArgumentException("Unsupported value type");
        }
    }

    public void testDropdown() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        DropdownHandler dropdownHandler = new DropdownHandler(driver);
        dropdownHandler.selectDropdownValue(By.cssSelector("[data-test='product-sort-container']"), "Price (low to high)");

        driver.quit();
    }

    public static void main(String[] args) {
        DropdownHandler dropdownHandler = new DropdownHandler();
        dropdownHandler.testDropdown();
    }
}
