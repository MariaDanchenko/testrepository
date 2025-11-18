package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage15 extends BasePage14 {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage15(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {

        System.out.println("Вводим логин: " + username);
        WebElement usernameElement = waitForElement(usernameField);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {

        System.out.println("Вводим пароль: " + password);
        WebElement passwordElement = waitForElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {

        System.out.println("Нажимаем кнопку 'Login'");
        WebElement button = waitForElement(loginButton);
        button.click();
    }

    public String getErrorMessage() {
        System.out.println("Получаем текст сообщения об ошибке");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver -> !driver.findElement(errorMessage).getText().isEmpty());

        return driver.findElement(errorMessage).getText();
    }

    public By getUsernameField() {
        return usernameField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getErrorMessageLoc() {
        return errorMessage;
    }
}
