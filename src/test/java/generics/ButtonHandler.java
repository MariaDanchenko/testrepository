package generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonHandler {

    private WebDriver driver;

    public ButtonHandler(WebDriver driver) {
        this.driver = driver;
    }

    public ButtonHandler() {}

    public <T> void clickButton(T elementOrLocator) {
        if (elementOrLocator instanceof By) {
            WebElement element = driver.findElement((By) elementOrLocator);
            element.click();
        } else if (elementOrLocator instanceof WebElement) {
            ((WebElement) elementOrLocator).click();
        } else {
            throw new IllegalArgumentException("Unsupported value type");
        }
    }

    public void testButtonHandler() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        usernameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("secret_sauce");

        ButtonHandler buttonHandler = new ButtonHandler(driver);
        buttonHandler.clickButton(By.cssSelector("#login-button"));

        driver.quit();
    }

    public static void main(String[] args) {
        ButtonHandler buttonHandler = new ButtonHandler();
        buttonHandler.testButtonHandler();
    }
}
