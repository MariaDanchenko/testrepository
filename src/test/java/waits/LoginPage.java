package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    protected WebDriver driver;

    private final By usernameField = By.cssSelector("#user-name");
    private final By passwordField = By.cssSelector("#password");
    private final By loginButton = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterUsername(String username) {

        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
