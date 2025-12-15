package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormHandler {

    protected WebDriver driver;

    public FormHandler(WebDriver driver) {
        this.driver = driver;
    }

    public FormHandler() {}

    public <T> void fillInputField(By locator, T value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value.toString());
    }

    public void testForm() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        FormHandler formHandler = new FormHandler(driver);
        formHandler.fillInputField(By.cssSelector("#user-name"), "standard_user");
        formHandler.fillInputField(By.cssSelector("#password"), "secret_sauce");

        driver.quit();
    }

    public static void main(String[] args) {
        FormHandler formHandler = new FormHandler();
        formHandler.testForm();
    }
}
