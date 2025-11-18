package hw.firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage13 extends BasePage12 {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage13(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {

        WebElement usernameElement = waitForElement(usernameField);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = waitForElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement button = waitForElement(loginButton);
        button.click();
    }

    public String getErrorMessage() {
        WebElement error = waitForElement(errorMessage);
        return error.getText();
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
