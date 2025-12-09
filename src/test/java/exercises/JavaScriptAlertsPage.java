package exercises;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {

    private WebDriver driver;

    private final By buttonJSAlert = By.cssSelector("button[onclick = 'jsAlert()']");
    private final By buttonJSConfirm = By.cssSelector("button[onclick = 'jsConfirm()']");
    private final By buttonJSPrompt = By.cssSelector("button[onclick = 'jsPrompt()']");
    private final By resultText = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForJSAlert() {
        driver.findElement(buttonJSAlert).click();
    }

    public void clickForJSConfirm() {
        driver.findElement(buttonJSConfirm).click();
    }

    public void clickForJSPrompt() {
        driver.findElement(buttonJSPrompt).click();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendTextToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getText() {
        return driver.findElement(resultText).getText();
    }
}
